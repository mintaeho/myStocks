package com.nuritech.stock.my_stock.interested.domain;

import com.nuritech.stock.my_stock.common.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 나의포트폴리오 Entity
 */
@Getter
@NoArgsConstructor
@Entity
public class InterestedStock extends BaseTimeEntity {

    @EmbeddedId
    private InterestedStockId interestedStockId;

    @Column(length = 100, nullable = true)
    private String stockNm;

    @Column(length = 100, nullable = true)
    private String businessCycle;

    @Column(length = 1, nullable = true)
    private String nobilityStockYn;

    @Column(nullable = true)
    private BigDecimal divYield;

    @Column(nullable = true)
    private BigDecimal annualPayout;

    @Column(nullable = true)
    private BigDecimal payoutRatio;

    @Column(nullable = true)
    private BigDecimal fiveYearGrowthRate;

    @Column(length = 3, nullable = true)
    private String dividendGrowth;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String companyInfo;


    @Builder
    public InterestedStock(InterestedStockId interestedStockId,
                           String stockNm,
                           String businessCycle,
                           String nobilityStockYn,
                           BigDecimal divYield,
                           BigDecimal annualPayout,
                           BigDecimal payoutRatio,
                           BigDecimal fiveYearGrowthRate,
                           String dividendGrowth,
                           String companyInfo) {
        this.interestedStockId = interestedStockId;
        this.stockNm = stockNm;
        this.businessCycle = businessCycle;
        this.nobilityStockYn = nobilityStockYn;
        this.divYield = divYield;
        this.annualPayout = annualPayout;
        this.payoutRatio = payoutRatio;
        this.fiveYearGrowthRate = fiveYearGrowthRate;
        this.dividendGrowth = dividendGrowth;
        this.companyInfo = companyInfo;
    }

    public void update(InterestedStockId interestedStockId,
                       String stockNm,
                       String businessCycle,
                       String nobilityStockYn,
                       BigDecimal divYield,
                       BigDecimal annualPayout,
                       BigDecimal payoutRatio,
                       BigDecimal fiveYearGrowthRate,
                       String dividendGrowth,
                       String companyInfo) {
        this.interestedStockId = interestedStockId;
        this.stockNm = stockNm;
        this.businessCycle = businessCycle;
        this.nobilityStockYn = nobilityStockYn;
        this.divYield = divYield;
        this.annualPayout = annualPayout;
        this.payoutRatio = payoutRatio;
        this.fiveYearGrowthRate = fiveYearGrowthRate;
        this.dividendGrowth = dividendGrowth;
        this.companyInfo = companyInfo;

    }
}
