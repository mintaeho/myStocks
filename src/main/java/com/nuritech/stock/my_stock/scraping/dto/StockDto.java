package com.nuritech.stock.my_stock.scraping.dto;

import com.nuritech.stock.my_stock.exercise.book.domain.posts.Posts;
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
    //private BigDecimal divYield;
    //private BigDecimal annualPayout;
    //private BigDecimal payoutRatio;
    //private BigDecimal fiveYearGrowthRate;
    //private Integer dividendGrowth;
    private String dividendPayMonth;
    private BigDecimal highestPrice;
    private BigDecimal lowerPrice;

    public StockDto(Stock entity) {
        this.ticker = entity.getTicker();
        this.stockNm = entity.getStockNm();
        this.businessCycle = entity.getBusinessCycle();
        this.sector = entity.getSector();
        this.currentPrice = entity.getCurrentPrice();
        this.dividendPayMonth = entity.getDividendPayMonth();
        this.highestPrice = entity.getHighestPrice();
        this.lowerPrice = entity.getLowerPrice();
    }

    @Builder
    public StockDto(String ticker,
                    String stockNm,
                    String businessCycle,
                    String sector,
                    BigDecimal currentPrice,
                    //BigDecimal divYield,
                    //BigDecimal annualPayout,
                    //BigDecimal payoutRatio,
                    //BigDecimal fiveYearGrowthRate,
                    //Integer dividendGrowth,
                    String dividendPayMonth,
                    BigDecimal highestPrice,
                    BigDecimal lowerPrice) {
        this.ticker = ticker;
        this.stockNm = stockNm;
        this.businessCycle = businessCycle;
        this.sector = sector;
        this.currentPrice = currentPrice;
        //this.divYield = divYield;
        //this.annualPayout = annualPayout;
        //this.payoutRatio = payoutRatio;
        //this.fiveYearGrowthRate = fiveYearGrowthRate;
        //this.dividendGrowth = dividendGrowth;
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
                .currentPrice(currentPrice)         // ?????????
                //.divYield(divYield)                 // ???????????????
                //.annualPayout(annualPayout)         // ???????????????
                //.payoutRatio(payoutRatio)           // ????????????
                //.fiveYearGrowthRate(fiveYearGrowthRate) // 5??? ?????????
                //.dividendGrowth(dividendGrowth)         // ??????????????????
                .dividendPayMonth(dividendPayMonth)     // ?????????
                .highestPrice(highestPrice)             // 52??? ?????????
                .lowerPrice(lowerPrice)                 // 52??? ?????????
                .build();
    }
}
