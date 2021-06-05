package com.nuritech.stock.my_stock.interested.dto;

import com.nuritech.stock.my_stock.interested.domain.InterestedStock;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class InterestedStockResponseDto {
    private String email;
    private String ticker;
    private String stockNm;
    private String businessCycle;
    private String sector;
    private String nobilityStockYn;
    private BigDecimal divYield;
    private BigDecimal annualPayout;
    private BigDecimal payoutRatio;
    private BigDecimal fiveYearGrowthRate;
    private String dividendGrowth;
    private String companyInfo;

    public InterestedStockResponseDto(InterestedStock entity) {
        this.email = entity.getInterestedStockId().getEmail();
        this.ticker = entity.getInterestedStockId().getTicker();
        this.stockNm = entity.getStockNm();
        this.businessCycle = entity.getBusinessCycle();
        this.sector = entity.getSector();
        this.nobilityStockYn = entity.getNobilityStockYn();
        this.divYield = entity.getDivYield();
        this.annualPayout = entity.getAnnualPayout();
        this.payoutRatio = entity.getPayoutRatio();
        this.fiveYearGrowthRate = entity.getFiveYearGrowthRate();
        this.dividendGrowth = entity.getDividendGrowth();
        this.companyInfo = entity.getCompanyInfo();
    }

}
