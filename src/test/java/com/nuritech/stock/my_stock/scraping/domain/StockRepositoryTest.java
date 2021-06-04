package com.nuritech.stock.my_stock.scraping.domain;

import com.nuritech.stock.my_stock.scraping.dto.StockDto;
import com.nuritech.stock.my_stock.scraping.dto.StockListDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StockRepositoryTest {

    @Autowired
    StockRepository stockRepository;

    @AfterEach      // junit5
    public void cleanup() {
        stockRepository.deleteById("TEST");
    }

    @Test
    public void Stock저장_불러오기_리스트조회() {
        String ticker = "TEST";
        String stockNm = "Test Stock";
        String businessCycle = "";
        String sector = "Communication Services";
        BigDecimal currentPrice = new BigDecimal(111.11);
        BigDecimal divYield = new BigDecimal(12.12);
        BigDecimal annualPayout = new BigDecimal(1.10);
        BigDecimal payoutRatio = new BigDecimal(55.55);
        BigDecimal fiveYearGrowthRate = new BigDecimal(4.55);
        Integer dividendGrowth = 22;
        BigDecimal highestPrice = new BigDecimal(200.22);
        BigDecimal lowerPrice = new BigDecimal(80.22);
        String dividendPayMonth = "3,6,9,12";

        LocalDateTime now = LocalDateTime.of(2021,5,8,0,0,0);

        StockDto stockDto = StockDto.builder()
                .ticker(ticker)
                .stockNm(stockNm)
                .businessCycle(businessCycle)
                .sector(sector)
                .currentPrice(currentPrice)
                //.divYield(divYield)
                //.annualPayout(annualPayout)
                //.payoutRatio(payoutRatio)
                //.fiveYearGrowthRate(fiveYearGrowthRate)
                //.dividendGrowth(dividendGrowth)
                .highestPrice(highestPrice)
                .lowerPrice(lowerPrice)
                .dividendPayMonth(dividendPayMonth)
                .build();

        stockRepository.save(stockDto.toEntity());

        Optional<Stock> stock = stockRepository.findById(ticker);
        assertThat(stock.get().getStockNm()).isEqualTo("Test Stock");
        assertThat(stock.get().getCreatedDate()).isAfter(now);
        assertThat(stock.get().getModifiedDate()).isAfter(now);

        // 리스트 조회
        boolean isExistsData = false;
        List<StockListDto> stockListDtoList = stockRepository.findAllDesc().stream()
                .map(StockListDto::new)
                .collect(Collectors.toList());
        for(StockListDto stockListDto : stockListDtoList) {
            if (ticker == stockListDto.getTicker()) isExistsData = true;
        }
        assertThat(isExistsData);


    }

}
