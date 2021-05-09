package com.nuritech.stock.my_stock.interested.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Embeddable
public class InterestedStockId implements Serializable {
    @Column(name = "email")
    private String email;

    @Column(name = "ticker")
    private String ticker;

    @Builder
    public InterestedStockId(String email,
                             String ticker) {
        this.email = email;
        this.ticker = ticker;
    }

}
