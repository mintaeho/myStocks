package com.nuritech.stock.my_stock.portfolio.domain;

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
public class Portfolio extends BaseTimeEntity {

    @EmbeddedId
    private PortfolioId portfolioId;

    @Builder
    public Portfolio(PortfolioId portfolioId) {
        this.portfolioId = portfolioId;
    }

    public void update(PortfolioId portfolioId) {
        this.portfolioId = portfolioId;
    }
}
