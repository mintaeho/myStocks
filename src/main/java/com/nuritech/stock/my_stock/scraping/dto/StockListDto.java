package com.nuritech.stock.my_stock.scraping.dto;

import com.nuritech.stock.my_stock.scraping.domain.Stock;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class StockListDto {
    private String ticker;
    private String stockNm;
    private String businessCycle;
    private String sector;
    private BigDecimal currentPrice;
    //private BigDecimal divYield;
    //private BigDecimal annualPayout;
    //private BigDecimal payoutRatio;
    //private BigDecimal fiveYearGrowthRate;
    //private Integer dividendGrowth;
    private String dividendPayMonth;

    private LocalDateTime modifiedDate;

    public StockListDto(Stock entity) {
        this.ticker = entity.getTicker();
        this.stockNm = entity.getStockNm();
        this.businessCycle = entity.getBusinessCycle();
        this.sector = entity.getSector();
        this.currentPrice = entity.getCurrentPrice();
        //this.divYield = entity.getDivYield();
        //this.annualPayout = entity.getAnnualPayout();
        //this.payoutRatio = entity.getPayoutRatio();
        //this.fiveYearGrowthRate = entity.getFiveYearGrowthRate();
        //this.dividendGrowth = entity.getDividendGrowth();
        this.dividendPayMonth = entity.getDividendPayMonth();
        this.modifiedDate = entity.getModifiedDate();
    }
}
