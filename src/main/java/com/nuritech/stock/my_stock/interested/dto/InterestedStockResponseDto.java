package com.nuritech.stock.my_stock.interested.dto;

import com.nuritech.stock.my_stock.interested.domain.InterestedStock;
import lombok.Getter;

@Getter
public class InterestedStockResponseDto {
    private String email;
    private String ticker;
    private String stockNm;
    private String businessCycle;
    private String nobilityStockYn;
    private String dividendPayMonth;
    private String companyInfo;

    public InterestedStockResponseDto(InterestedStock entity) {
        this.email = entity.getInterestedStockId().getEmail();
        this.ticker = entity.getInterestedStockId().getTicker();
        this.stockNm = entity.getStockNm();
        this.businessCycle = entity.getBusinessCycle();
        this.nobilityStockYn = entity.getNobilityStockYn();
        this.dividendPayMonth = entity.getDividendPayMonth();
        this.companyInfo = entity.getCompanyInfo();
    }

}
