package com.nuritech.stock.my_stock.daybook.dto;

import com.nuritech.stock.my_stock.daybook.domain.Daybooks;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class DaybooksSaveRequestDto {
    private String tradingDate;
    private String email;
    private String ticker;
    private BigDecimal unitPrice;
    private Integer stockNum;
    private String tradingType;
    private BigDecimal tradingAmount;
    private BigDecimal fee;
    private BigDecimal exchangeRate;

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Builder
    public DaybooksSaveRequestDto(String tradingDate,
                                  String email,
                                  String ticker,
                                  BigDecimal unitPrice,
                                  Integer stockNum,
                                  String tradingType,
                                  BigDecimal tradingAmount,
                                  BigDecimal fee,
                                  BigDecimal exchangeRate) {
        this.tradingDate = tradingDate;
        this.email = email;
        this.ticker = ticker;
        this.unitPrice = unitPrice;
        this.stockNum = stockNum;
        this.tradingType = tradingType;
        this.tradingAmount = tradingAmount;
        this.fee = fee;
        this.exchangeRate = exchangeRate;
    }

    public Daybooks toEntity() {
        return Daybooks.builder()
                .tradingDate(tradingDate)
                .email(email)
                .ticker(ticker)
                .unitPrice(unitPrice)
                .stockNum(stockNum)
                .tradingType(tradingType)
                .tradingAmount(tradingAmount)
                .fee(fee)
                .exchangeRate(exchangeRate)
                .build();
    }
}
