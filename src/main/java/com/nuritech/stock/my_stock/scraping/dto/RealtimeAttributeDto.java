package com.nuritech.stock.my_stock.scraping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class RealtimeAttributeDto {
    private String identifier;
    private String name;
    private BigDecimal last;
    private BigDecimal change;
    private BigDecimal percentChange;
    private BigDecimal previousClose;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal volume;
    private String dataTime;
    private String quoteInfo;
    private BigDecimal close;
    private BigDecimal changeFromPreviousClose;
    private BigDecimal percentChangeFromPreviousClose;
    private BigDecimal low52Week;
    private BigDecimal high52Week;
    private BigDecimal extendedHoursPrice;
    private BigDecimal extendedHoursChange;
    private BigDecimal extendedHoursPercentChange;
    private String extendedHoursDateTime;
    private String extendedHoursType;
    private String sourceAPI;


}
