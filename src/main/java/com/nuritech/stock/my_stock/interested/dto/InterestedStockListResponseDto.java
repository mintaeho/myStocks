package com.nuritech.stock.my_stock.interested.dto;

import com.nuritech.stock.my_stock.interested.domain.InterestedStock;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class InterestedStockListResponseDto {
    private String email;
    private String ticker;
    private String stockNm;
    private String businessCycle;
    private LocalDateTime modifiedDate;


    public InterestedStockListResponseDto(InterestedStock entity) {
        this.email = entity.getInterestedStockId().getEmail();
        this.ticker = entity.getInterestedStockId().getTicker();
        this.stockNm = entity.getStockNm();
        this.businessCycle = entity.getBusinessCycle();
        this.modifiedDate = entity.getModifiedDate();
    }

}
