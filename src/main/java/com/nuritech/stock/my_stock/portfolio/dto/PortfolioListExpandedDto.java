package com.nuritech.stock.my_stock.portfolio.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PortfolioListExpandedDto {
    private String ticker;
    private String stockNm;
    private String businessCycle;
    private String sector;
    private BigDecimal currentPrice;
    private BigDecimal highestPrice;
    private BigDecimal lowerPrice;
    private BigDecimal avgUnitPrice;
    private BigDecimal totalStockNum;
    private BigDecimal annualPayout;
    private BigDecimal totalPayout;
    private BigDecimal investmentDivYield;
    private BigDecimal totalTradingAmount;
    private BigDecimal evalAmount;
    private BigDecimal earningAmount;
    private BigDecimal earningRate;
    private BigDecimal portion;
    private String dividendPayMonth;
    private LocalDateTime modifiedDate;


    @Builder
    public PortfolioListExpandedDto(String ticker,
                                    String stockNm,
                                    String businessCycle,
                                    String sector,
                                    BigDecimal currentPrice,
                                    BigDecimal highestPrice,
                                    BigDecimal lowerPrice,
                                    BigDecimal avgUnitPrice,
                                    BigDecimal totalStockNum,
                                    BigDecimal annualPayout,
                                    BigDecimal totalPayout,
                                    BigDecimal investmentDivYield,
                                    BigDecimal totalTradingAmount,
                                    BigDecimal evalAmount,
                                    BigDecimal earningAmount,
                                    BigDecimal earningRate,
                                    BigDecimal portion,
                                    String dividendPayMonth) {
        this.ticker = ticker;
        this.stockNm =  stockNm;
        this.businessCycle = businessCycle;
        this.sector = sector;
        this.currentPrice = currentPrice;
        this.highestPrice = highestPrice;
        this.lowerPrice = lowerPrice;
        this.avgUnitPrice = avgUnitPrice;
        this.totalStockNum = totalStockNum;
        this.annualPayout = annualPayout;
        this.totalPayout = totalPayout;
        this.investmentDivYield = investmentDivYield;
        this.totalTradingAmount = totalTradingAmount;
        this.evalAmount = evalAmount;
        this.earningAmount = earningAmount;
        this.earningRate = earningRate;
        this.portion = portion;
        this.dividendPayMonth = dividendPayMonth;
    }


    public List<PortfolioListExpandedDto> toDto(List<Object[]> objects) {
        List<PortfolioListExpandedDto> list = new ArrayList<PortfolioListExpandedDto>();
        for(Object[] obj : objects) {
            list.add(PortfolioListExpandedDto.builder()
                    .ticker((String) obj[0])
                    .stockNm((String) obj[1])
                    .businessCycle((String) obj[2])
                    .sector((String) obj[3])
                    .currentPrice(this.toBigDecimal(obj[4]))
                    .avgUnitPrice(this.toBigDecimal(obj[5]))
                    .totalStockNum(this.toBigDecimal(obj[6]))
                    .annualPayout(this.toBigDecimal(obj[7]))
                    .highestPrice(this.toBigDecimal(obj[8]))
                    .lowerPrice(this.toBigDecimal(obj[9]))
                    .totalPayout(this.toBigDecimal(obj[10]))
                    .investmentDivYield(this.toBigDecimal(obj[11]))
                    .totalTradingAmount(this.toBigDecimal(obj[12]))
                    .evalAmount(this.toBigDecimal(obj[13]))
                    .earningAmount(this.toBigDecimal(obj[14]))
                    .earningRate(this.toBigDecimal(obj[15]))
                    .portion(this.toBigDecimal(obj[16]))
                    .dividendPayMonth((String) obj[17])
                    .build());
        }
        return list;
    }

    private BigDecimal toBigDecimal(Object obj) {
        if (obj instanceof BigInteger) {
            return new BigDecimal(obj.toString());
        } else {
            return (BigDecimal) obj;
        }
    }

}
