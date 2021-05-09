package com.nuritech.stock.my_stock.portfolio.dto;


import com.nuritech.stock.my_stock.portfolio.domain.Portfolio;
import com.nuritech.stock.my_stock.portfolio.domain.PortfolioId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PortfolioSaveRequestDto {
    private String email;
    private String ticker;

    public void setEmail(String email) {
        this.email = email;
    }

    @Builder
    public PortfolioSaveRequestDto(String email, String ticker) {
        this.email = email;
        this.ticker = ticker;
    }

    public Portfolio toEntity() {
        return Portfolio.builder()
                .portfolioId(PortfolioId.builder()
                                                    .email(email)
                                                    .ticker(ticker)
                                                    .build())
                .build();
    }
}
