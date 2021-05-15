package com.nuritech.stock.my_stock.interested.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InterestedStockUpdateRequestDto {
    private String stockNm;
    private String businessCycle;
    private String nobilityStockYn;
    private String dividendPayMonth;

    @Builder
    public InterestedStockUpdateRequestDto(String stockNm,
                                           String businessCycle,
                                           String nobilityStockYn,
                                           String dividendPayMonth) {
        this.stockNm = stockNm;
        this.businessCycle = businessCycle;
        this.nobilityStockYn = nobilityStockYn;
        this.dividendPayMonth = dividendPayMonth;
    }

}
