package com.nuritech.stock.my_stock.interested.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class InterestedStockUpdateRequestDto {
    private String stockNm;
    private String businessCycle;
    private String nobilityStockYn;
    private BigDecimal divYield;
    private BigDecimal annualPayout;
    private BigDecimal payoutRatio;
    private BigDecimal fiveYearGrowthRate;
    private String dividendGrowth;
    private String companyInfo;

    @Builder
    public InterestedStockUpdateRequestDto(String stockNm,
                                           String businessCycle,
                                           String nobilityStockYn,
                                           BigDecimal divYield,
                                           BigDecimal annualPayout,
                                           BigDecimal payoutRatio,
                                           BigDecimal fiveYearGrowthRate,
                                           String dividendGrowth,
                                           String companyInfo) {
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
