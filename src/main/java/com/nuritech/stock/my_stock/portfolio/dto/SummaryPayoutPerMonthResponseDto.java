package com.nuritech.stock.my_stock.portfolio.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SummaryPayoutPerMonthResponseDto {
    private String dividendPayMonth;
    private BigDecimal totalPayout;
    private BigDecimal payoutMonth;

    @Builder
    public SummaryPayoutPerMonthResponseDto(String dividendPayMonth,
                                            BigDecimal totalPayout,
                                            BigDecimal payoutMonth) {
        this.dividendPayMonth = dividendPayMonth;
        this.totalPayout =  totalPayout;
        this.payoutMonth = payoutMonth;
    }


    public List<SummaryPayoutPerMonthResponseDto> toDto(List<Object[]> objects) {
        List<SummaryPayoutPerMonthResponseDto> list = new ArrayList<SummaryPayoutPerMonthResponseDto>();
        for(Object[] obj : objects) {
            list.add(SummaryPayoutPerMonthResponseDto.builder()
                    .dividendPayMonth((String) obj[0])
                    .totalPayout((BigDecimal) obj[1])
                    .payoutMonth((BigDecimal) obj[2])
                    .build());
        }
        return list;
    }

}
