package com.nuritech.stock.my_stock.scraping.web;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.nuritech.stock.my_stock.interested.dto.InterestedStockListResponseDto;
import com.nuritech.stock.my_stock.interested.dto.InterestedStockSaveRequestDto;
import com.nuritech.stock.my_stock.interested.service.InterestedStockService;
import com.nuritech.stock.my_stock.scraping.service.ScrapService;
import com.nuritech.stock.my_stock.scraping.dto.StockDto;
import com.nuritech.stock.my_stock.scraping.dto.DividendAttributeDto;
import com.nuritech.stock.my_stock.scraping.dto.DividendDataDto;
import com.nuritech.stock.my_stock.scraping.dto.RealtimeDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Slf4j
@RequiredArgsConstructor
@RestController
public class ScrapApiController {

    private final String REAL_TIME_PRICE_URL = "https://finance.api.seekingalpha.com/v2/real-time-prices?symbols=";
    private final String API_SYMBOL_URL = "https://seekingalpha.com/api/v3/symbol_data";

    private final String PRICE_INFO_URL = "https://cloud.iexapis.com/stable/stock/";
    private final String DIVIDEND_INFO_URL = "https://cloud.iexapis.com/v1/stock/";
    private final String IEXCLOUD_API_TOKEN = "pk_75cd7d9795dd40468a201dfcb86cd867";

    private final ScrapService scrapService;
    private final InterestedStockService interestedStockService;

    @PostMapping("/api/v1/scrap")
    public String scrap() {

        log.debug(">>>>>>>> scrap method start..............");
        StringBuilder stockUrl = new StringBuilder();

        // 1. 관심종목 DB에 티커들을 조회
        //List<StockListDto> stockDtoList = scrapService.findAllDesc();
        List<InterestedStockListResponseDto> interestedStockListResponseDtoList = interestedStockService.findAllDesc();

        // 2. 루프를 돌면서 해당정보 스크랩
        interestedStockListResponseDtoList.forEach(list -> {
            log.debug("stockListDto.getTicker() : {}", list.getTicker());

            String ticker = list.getTicker();
            try {
                Gson gson = new Gson();
                RealtimeDataDto realtimeInfo = gson.fromJson(getRealTimeInfo(ticker).toString(),
                        RealtimeDataDto.class);

                Gson gson2 = new Gson();
                DividendAttributeDto[] dividendInfo = gson2.fromJson(getDividendInfo(ticker).toString(),
                        DividendAttributeDto[].class);

                //log.debug("dividend info : {}", dividendInfo.getData().get(0).getAttributes().getDivYieldFwd());

                String[] tmpDivPayMon = new String[4];

                if ( "O".equals(ticker) ) {
                    tmpDivPayMon[0] = "per months";
                } else {
                    int i=0;
                    for (DividendAttributeDto div : dividendInfo) {
                        if (i>=4) break;
                        log.debug(">>>div.getPaymentDate() {}", div.getPaymentDate());
                        tmpDivPayMon[i++] = div.getPaymentDate().split("-")[1];
                    }
                    Arrays.sort(tmpDivPayMon);
                }

                log.debug(">>>>tmpDivPayMon[]={}", String.join(",", tmpDivPayMon));
                StockDto stockDto = StockDto.builder()
                        .ticker(realtimeInfo.getSymbol())
                        .stockNm(realtimeInfo.getCompanyName())
                        .businessCycle("")
                        .sector("")
                        .currentPrice(realtimeInfo.getLatestPrice())
                        //.divYield()
                        //.annualPayout()
                        //.payoutRatio()
                        //.fiveYearGrowthRate()
                        //.dividendGrowth()
                        .highestPrice(realtimeInfo.getWeek52High())
                        .lowerPrice(realtimeInfo.getWeek52Low())
                        .dividendPayMonth(String.join(",", tmpDivPayMon))
                        .build();

                scrapService.stockSave(stockDto);

            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

        });

        // 3. 관심정보 저장

        //return postsService.save(requestDto);
        return "SUCCESS";
    }

    private StringBuilder getRealTimeInfo(String ticker) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(makeRealTimeUrl(ticker));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setDoOutput(false);


            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Stream을 처리해줘야 하는 귀찮음이 있음.
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    sb.append(inputLine).append("\n");
                }
                br.close();
                //log.debug(sb.toString());
            } else {
                log.info(con.getResponseMessage());
            }
            con.disconnect();


        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return sb;
    }

    private StringBuilder getDividendInfo(String ticker) {

        StringBuilder sb = new StringBuilder();

        log.debug("makeDividendUrl(ticker) : {}", makeDividendUrl(ticker));
        try {
            URL url = new URL(makeDividendUrl(ticker));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setDoOutput(false);


            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Stream을 처리해줘야 하는 귀찮음이 있음.
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    sb.append(inputLine).append("\n");
                }
                br.close();
                log.debug("response : {}", sb.toString());
            } else {
                log.info(con.getResponseMessage());
            }
            con.disconnect();

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return sb;
    }


    private String makeRealTimeUrl(String ticker) {
        return new StringBuilder()
                .append(PRICE_INFO_URL)
                .append(ticker)
                .append("/quote?token=")
                .append(IEXCLOUD_API_TOKEN).toString();
    }
    private String makeDividendUrl(String ticker) {
        DividendAttributeDto param = new DividendAttributeDto();
        return new StringBuilder().append(DIVIDEND_INFO_URL)
                .append(ticker)
                .append("/dividends/1y?token=")
                .append(IEXCLOUD_API_TOKEN).toString();
    }


    @PostMapping("/api/v1/scrap/manual")
    public String scrapManual(@RequestBody String requestStr) {
        String strJson = requestStr.replaceAll("(\r\n|\r|\n|\n\r|\\p{Z}|\\t|\\\\)", "");

        try {

            //String ticker = dividendInfo.getData().get(0).getId();
            String ticker = "MO";
            Gson gson = new Gson();
            String tmp = getRealTimeInfo(ticker).toString();
            System.out.println(">>>>>tmp="+tmp);
            RealtimeDataDto realtimeInfo = gson.fromJson(tmp,
                    RealtimeDataDto.class);

            System.out.println(">>>realtimeInfo="+realtimeInfo.toString());


            /*
            StockDto stockDto = StockDto.builder()
                    .ticker(realtimeInfo.getData().get(0).getAttributes().getIdentifier())
                    .stockNm(realtimeInfo.getData().get(0).getAttributes().getName())
                    .businessCycle("")
                    .sector(dividendInfo.getData().get(0).getAttributes().getSectorname())
                    .currentPrice(realtimeInfo.getData().get(0).getAttributes().getLast())
                    .divYield(dividendInfo.getData().get(0).getAttributes().getDivYieldFwd())
                    .annualPayout(dividendInfo.getData().get(0).getAttributes().getDivRate())
                    .payoutRatio(dividendInfo.getData().get(0).getAttributes().getPayoutRatio())
                    .fiveYearGrowthRate(dividendInfo.getData().get(0).getAttributes().getDivGrowRate5())
                    .dividendGrowth(dividendInfo.getData().get(0).getAttributes().getDividendGrowth())
                    .highestPrice(realtimeInfo.getData().get(0).getAttributes().getHigh52Week())
                    .lowerPrice(realtimeInfo.getData().get(0).getAttributes().getLow52Week())
                    //.dividendPayMonth("")
                    .build();

            scrapService.stockSave(stockDto);
            */

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return "SUCCESS";
    }

}
