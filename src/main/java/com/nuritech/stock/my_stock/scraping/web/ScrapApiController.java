package com.nuritech.stock.my_stock.scraping.web;

import com.google.gson.Gson;
import com.nuritech.stock.my_stock.interested.dto.InterestedStockListResponseDto;
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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
public class ScrapApiController {

    private final String REAL_TIME_PRICE_URL = "https://finance.api.seekingalpha.com/v2/real-time-prices?symbols=";
    private final String API_SYMBOL_URL = "https://seekingalpha.com/api/v3/symbol_data";


    private final ScrapService scrapService;
    private final InterestedStockService interestedStockService;

    @PostMapping("/api/v1/scrap")
    public String scrap() {

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

                log.debug("realtimeInfo getHigh : {}", realtimeInfo.getData().get(0).getAttributes().getHigh());
                log.debug("realtimeInfo getHigh52Week : {}", realtimeInfo.getData().get(0).getAttributes().getHigh52Week());

                Gson gson2 = new Gson();
                DividendDataDto dividendInfo = gson2.fromJson(getDividendInfo(ticker).toString(),
                        DividendDataDto.class);

                //log.debug("dividend info : {}", dividendInfo.getData().get(0).getAttributes().getDivYieldFwd());

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
        return new StringBuilder().append(REAL_TIME_PRICE_URL).append(ticker).toString();
    }
    private String makeDividendUrl(String ticker) {
        DividendAttributeDto param = new DividendAttributeDto();
        return new StringBuilder().append(API_SYMBOL_URL)
                .append("?")
                .append(param.toParameter())
                .append("&slugs=")
                .append(ticker).toString();
    }
}
