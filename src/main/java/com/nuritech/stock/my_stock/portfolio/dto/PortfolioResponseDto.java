package com.nuritech.stock.my_stock.portfolio.dto;

import com.nuritech.stock.my_stock.interested.domain.InterestedStock;
import com.nuritech.stock.my_stock.portfolio.domain.Portfolio;
import lombok.Getter;

@Getter
public class PortfolioResponseDto {
    private String email;
    private String ticker;


    public PortfolioResponseDto(Portfolio entity) {
        this.email = entity.getPortfolioId().getEmail();
        this.ticker = entity.getPortfolioId().getTicker();
    }

}
