package com.nuritech.stock.my_stock.portfolio.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
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
    private LocalDateTime modifiedDate;


    @Builder
    public PortfolioListExpandedDto(String ticker,
                                    String stockNm,
                                    String businessCycle,
                                    String sector,
                                    BigDecimal currentPrice,
                                    BigDecimal avgUnitPrice,
                                    BigDecimal totalStockNum,
                                    BigDecimal annualPayout,
                                    BigDecimal totalPayout,
                                    BigDecimal investmentDivYield,
                                    BigDecimal totalTradingAmount,
                                    BigDecimal evalAmount,
                                    BigDecimal earningAmount,
                                    BigDecimal earningRate,
                                    BigDecimal portion) {
        this.ticker = ticker;
        this.stockNm =  stockNm;
        this.businessCycle = businessCycle;
        this.sector = sector;
        this.currentPrice = currentPrice;
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
    }


    public List<PortfolioListExpandedDto> toDto(List<Object[]> objects) {
        List<PortfolioListExpandedDto> list = new ArrayList<PortfolioListExpandedDto>();
        for(Object[] obj : objects) {
            list.add(PortfolioListExpandedDto.builder()
                    .ticker((String) obj[0])
                    .stockNm((String) obj[1])
                    .businessCycle((String) obj[2])
                    .sector((String) obj[3])
                    .currentPrice((BigDecimal) obj[4])
                    .avgUnitPrice((BigDecimal) obj[5])
                    .totalStockNum((BigDecimal) obj[6])
                    .annualPayout((BigDecimal) obj[7])
                    .totalPayout((BigDecimal) obj[8])
                    .investmentDivYield((BigDecimal) obj[9])
                    .totalTradingAmount((BigDecimal) obj[10])
                    .evalAmount((BigDecimal) obj[11])
                    .earningAmount((BigDecimal) obj[12])
                    .earningRate((BigDecimal) obj[13])
                    .portion((BigDecimal) obj[14])
                    .build());
        }
        return list;
    }

}
