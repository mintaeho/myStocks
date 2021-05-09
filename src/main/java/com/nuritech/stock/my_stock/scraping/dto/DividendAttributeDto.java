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

    private BigDecimal divYieldFwd;
    private BigDecimal divRate;
    private BigDecimal payoutRatio;
    private BigDecimal divGrowRate5;
    private Integer dividendGrowth;
    private BigDecimal divYieldTtm;
    private String divDistribution;
    private String sectorname;
    private List<DividendQuarterlyDto> dividends;


    public String toParameter() {
        StringBuilder sb = new StringBuilder();
        try {
            Object obj = this;
            int idx = 0;

            for (Field field : obj.getClass().getDeclaredFields()) {
                //field.setAccessible(true);
                Object value = field.get(obj);
                sb.append(makeParam(field.getName(), idx==0));
                idx++;
            }
        } catch(Exception e) {
            log.error(e.getMessage(), e);
        }
        return sb.toString();

    }

    private String makeParam(String field,
                             boolean isFirst) {
        if (isFirst) {
            return new StringBuilder().append("fields[]=").append(field).toString();
        }
        return new StringBuilder().append("&fields[]=").append(field).toString();
    }


}
