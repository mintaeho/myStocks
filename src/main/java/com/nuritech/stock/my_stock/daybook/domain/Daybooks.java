package com.nuritech.stock.my_stock.daybook.domain;

import com.nuritech.stock.my_stock.common.domain.BaseTimeEntity;
import com.nuritech.stock.my_stock.interested.domain.InterestedStockId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 나의포트폴리오 Entity
 */
@Getter
@NoArgsConstructor
@Entity
public class Daybooks extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(length = 8, nullable = false)
    private String tradingDate;

    @Column(nullable = false)
    private String ticker;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    @Column(nullable = false)
    private Integer stockNum;

    @Column(nullable = false)
    private String tradingType;         //매수/매도

    @Column(nullable = false)
    private BigDecimal tradingAmount;

    @Column
    private BigDecimal fee;

    @Column
    private BigDecimal exchangeRate;

    @Builder
    public Daybooks(String tradingDate,
                    String email,
                    String ticker,
                    BigDecimal unitPrice,
                    Integer stockNum,
                    String tradingType,
                    BigDecimal tradingAmount,
                    BigDecimal fee,
                    BigDecimal exchangeRate) {
        this.email = email;
        this.tradingDate = tradingDate;
        this.ticker = ticker;
        this.unitPrice = unitPrice;
        this.stockNum = stockNum;
        this.tradingType = tradingType;
        this.tradingAmount = tradingAmount;
        this.fee = fee;
        this.exchangeRate = exchangeRate;
    }

    public void update(String tradingDate,
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
}
