package com.nuritech.stock.my_stock.daybook.dto;

import com.nuritech.stock.my_stock.daybook.domain.Daybooks;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class DaybooksListResponseDto {
    private Long id;
    private String tradingDate;
    private String email;
    private String ticker;
    private BigDecimal unitPrice;
    private Integer stockNum;
    private String tradingType;
    private BigDecimal tradingAmount;
    private BigDecimal fee;
    private BigDecimal exchangeRate;
    private LocalDateTime modifiedDate;

    public DaybooksListResponseDto(Daybooks entity) {
        this.id = entity.getId();
        this.tradingDate = entity.getTradingDate();
        this.email = entity.getEmail();
        this.ticker = entity.getTicker();
        this.unitPrice = entity.getUnitPrice();
        this.stockNum = entity.getStockNum();
        this.tradingType = entity.getTradingType();
        this.tradingAmount = entity.getTradingAmount();
        this.fee = entity.getFee();
        this.exchangeRate = entity.getExchangeRate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
