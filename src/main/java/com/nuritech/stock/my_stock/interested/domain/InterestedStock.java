package com.nuritech.stock.my_stock.interested.domain;

import com.nuritech.stock.my_stock.common.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 나의포트폴리오 Entity
 */
@Getter
@NoArgsConstructor
@Entity
public class InterestedStock extends BaseTimeEntity {

    @EmbeddedId
    private InterestedStockId interestedStockId;

    @Column(length = 100, nullable = true)
    private String stockNm;

    @Column(length = 100, nullable = true)
    private String businessCycle;

    @Column(length = 1, nullable = true)
    private String nobilityStockYn;

    @Column(length = 15, nullable = true)
    private String dividendPayMonth;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String companyInfo;


    @Builder
    public InterestedStock(InterestedStockId interestedStockId,
                           String stockNm,
                           String businessCycle,
                           String nobilityStockYn,
                           String dividendPayMonth,
                           String companyInfo) {
        this.interestedStockId = interestedStockId;
        this.stockNm = stockNm;
        this.businessCycle = businessCycle;
        this.nobilityStockYn = nobilityStockYn;
        this.dividendPayMonth = dividendPayMonth;
        this.companyInfo = companyInfo;
    }

    public void update(InterestedStockId interestedStockId,
                       String stockNm,
                       String businessCycle,
                       String nobilityStockYn,
                       String dividendPayMonth,
                       String companyInfo) {
        this.interestedStockId = interestedStockId;
        this.stockNm = stockNm;
        this.businessCycle = businessCycle;
        this.nobilityStockYn = nobilityStockYn;
        this.dividendPayMonth = dividendPayMonth;
        this.companyInfo = companyInfo;

    }
}
