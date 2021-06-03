package com.nuritech.stock.my_stock.scraping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Getter
@NoArgsConstructor
public class DividendAttributeDto {

    private String amount;
    private String currency;
    private String declaredDate;
    private String description;
    private String exDate;
    private String flag;
    private String frequency;
    private String paymentDate;
    private String recordDate;
    private int refid;
    private String symbol;
    private String id;
    private String key;
    private String subkey;
    private double date;
    private double updated;


}
