package com.nuritech.stock.my_stock.scraping.service;

import com.nuritech.stock.my_stock.scraping.dto.StockDto;
import com.nuritech.stock.my_stock.scraping.domain.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ScrapServiceTest {

    @Autowired
    ScrapService scrapService;

    @Autowired
    StockRepository stockRepository;

    @AfterEach      // junit5
    public void cleanup() {
        stockRepository.deleteById("TEST");
    }

    @Test
    public void stockSave_실행() {
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

        StockDto stockDto = StockDto.builder()
                .ticker(ticker)
                .stockNm(stockNm)
                .businessCycle(businessCycle)
                .sector(sector)
                .currentPrice(currentPrice)
                .divYield(divYield)
                .annualPayout(annualPayout)
                .payoutRatio(payoutRatio)
                .fiveYearGrowthRate(fiveYearGrowthRate)
                .dividendGrowth(dividendGrowth)
                .highestPrice(highestPrice)
                .lowerPrice(lowerPrice)
                .dividendPayMonth(dividendPayMonth)
                .build();

        String result = scrapService.stockSave(stockDto);
        assertThat(result).isEqualTo(ticker);
    }

}
