package com.nuritech.stock.my_stock.portfolio.dto;

import com.nuritech.stock.my_stock.interested.domain.InterestedStock;
import com.nuritech.stock.my_stock.portfolio.domain.Portfolio;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PortfolioListResponseDto {
    private String email;
    private String ticker;
    private LocalDateTime modifiedDate;


    public PortfolioListResponseDto(Portfolio entity) {
        this.email = entity.getPortfolioId().getEmail();
        this.ticker = entity.getPortfolioId().getTicker();
        this.modifiedDate = entity.getModifiedDate();
    }

}
