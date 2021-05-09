package com.nuritech.stock.my_stock.scraping.domain;

import com.nuritech.stock.my_stock.common.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 나의포트폴리오 Entity
 */
@Getter
@NoArgsConstructor
@Entity
public class Stock extends BaseTimeEntity {

    @Id
    private String ticker;

    @Column(length = 100, nullable = true)
    private String stockNm;

    @Column(length = 50, nullable = true)
    private String businessCycle;

    @Column(length = 50, nullable = true)
    private String sector;

    @Column
    private BigDecimal currentPrice;    //현재가

    @Column
    private BigDecimal divYield;  //배당수익률(%)

    @Column
    private BigDecimal annualPayout;    //연간 배당금

    @Column
    private BigDecimal payoutRatio;    //배당성향(%)

    @Column
    private BigDecimal fiveYearGrowthRate;  // 5년 성장률

    @Column
    private Integer dividendGrowth; // 배당성장년수

    @Column
    private String dividendPayMonth;    //배당월

    @Column
    private BigDecimal highestPrice;

    @Column
    private BigDecimal lowerPrice;

    @Builder
    public Stock(String ticker,
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

    public void update(String stockNm,
                       String businessCycle,
                       String sector,
                       BigDecimal currentPrice,
                       BigDecimal divYield,
                       BigDecimal annualPayout,
                       BigDecimal payoutRatio,
                       BigDecimal fiveYearGrowthRate,
                       int dividendGrowth,
                       String dividendPayMonth,
                       BigDecimal highestPrice,
                       BigDecimal lowerPrice) {
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
}
