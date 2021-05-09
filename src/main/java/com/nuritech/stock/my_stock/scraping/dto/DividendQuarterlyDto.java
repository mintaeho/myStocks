package com.nuritech.stock.my_stock.scraping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class DividendQuarterlyDto {

    private BigDecimal amount;
    private String date;
    private String exDate;
    private String payDate;
    private String recordDate;
    private String declareDate;
}
