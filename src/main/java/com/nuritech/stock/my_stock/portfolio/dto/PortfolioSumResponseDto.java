package com.nuritech.stock.my_stock.portfolio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class PortfolioSumResponseDto {
    private BigDecimal totalPayout;
    private BigDecimal totalTradingAmount;
    private BigDecimal totalEvalAmount;
    private BigDecimal earningAmount;
    private BigDecimal earningRate;



    @Builder
    public PortfolioSumResponseDto(BigDecimal totalPayout,
                                   BigDecimal totalTradingAmount,
                                   BigDecimal totalEvalAmount,
                                   BigDecimal earningAmount,
                                   BigDecimal earningRate) {
        this.totalPayout = totalPayout;
        this.totalTradingAmount =  totalTradingAmount;
        this.totalEvalAmount = totalEvalAmount;
        this.earningAmount = earningAmount;
        this.earningRate = earningRate;
    }


    public List<PortfolioSumResponseDto> toDto(List<Object[]> objects) {
        List<PortfolioSumResponseDto> list = new ArrayList<PortfolioSumResponseDto>();
        for(Object[] obj : objects) {
            list.add(PortfolioSumResponseDto.builder()
                    .totalPayout((BigDecimal) obj[0])
                    .totalTradingAmount((BigDecimal) obj[1])
                    .totalEvalAmount((BigDecimal) obj[2])
                    .earningAmount((BigDecimal) obj[3])
                    .earningRate((BigDecimal) obj[4])
                    .build());
        }
        return list;
    }

}
