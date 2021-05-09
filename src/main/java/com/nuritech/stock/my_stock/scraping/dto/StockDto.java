package com.nuritech.stock.my_stock.scraping.dto;

import com.nuritech.stock.my_stock.scraping.domain.Stock;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class StockDto {

    private String ticker;
    private String stockNm;
    private String businessCycle;
    private String sector;
    private BigDecimal currentPrice;
    private BigDecimal divYield;
    private BigDecimal annualPayout;
    private BigDecimal payoutRatio;
    private BigDecimal fiveYearGrowthRate;
    private Integer dividendGrowth;
    private String dividendPayMonth;
    private BigDecimal highestPrice;
    private BigDecimal lowerPrice;

    @Builder
    public StockDto(String ticker,
                    String stockNm,
                    String businessCycle,
                    String sector,
                    BigDecimal currentPrice,
                    BigDecimal divYield,
                    BigDecimal annualPayout,
                    BigDecimal payoutRatio,
                    BigDecimal fiveYearGrowthRate,
                    Integer dividendGrowth,
                    String dividendPayMonth,
                    BigDecimal highestPrice,
                    BigDecimal lowerPrice) {
        this.ticker = ticker;
        this.stockNm = stockNm;
        this.businessCycle = businessCycle;
        this.sector = sector;
        this.currentPrice = currentPrice;
        this.divYield = divYield;
        this.annualPayout = annualPayout;
        this.payoutRatio = payoutRatio;
        this.fiveYearGrowthRate = fiveYearGrowthRate;
        this.dividendGrowth = dividendGrowth;
        this.dividendPayMonth = dividendPayMonth;
        this.highestPrice = highestPrice;
        this.lowerPrice = lowerPrice;
    }

    public Stock toEntity() {
        return Stock.builder()
                .ticker(ticker)
                .stockNm(stockNm)
                .businessCycle(businessCycle)
                .sector(sector)
                .currentPrice(currentPrice)         // 현재가
                .divYield(divYield)                 // 배당수익율
                .annualPayout(annualPayout)         // 연간배당금
                .payoutRatio(payoutRatio)           // 배당성향
                .fiveYearGrowthRate(fiveYearGrowthRate) // 5년 성장률
                .dividendGrowth(dividendGrowth)         // 배당성장년수
                .dividendPayMonth(dividendPayMonth)     // 배당월
                .highestPrice(highestPrice)             // 52주 최고가
                .lowerPrice(lowerPrice)                 // 52주 최저가
                .build();
    }
}
