package com.nuritech.stock.my_stock.interested.dto;

import com.nuritech.stock.my_stock.interested.domain.InterestedStock;
import com.nuritech.stock.my_stock.interested.domain.InterestedStockId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class InterestedStockSaveRequestDto {
    private String email;
    private String ticker;
    private String stockNm;
    private String businessCycle;
    private String nobilityStockYn;
    private String dividendPayMonth;

    public void setEmail(String email) {
        this.email = email;
    }

    @Builder
    public InterestedStockSaveRequestDto(String email,
                                         String ticker,
                                         String stockNm,
                                         String businessCycle,
                                         String nobilityStockYn,
                                         String dividendPayMonth) {
        this.email = email;
        this.ticker = ticker;
        this.stockNm = stockNm;
        this.businessCycle = businessCycle;
        this.nobilityStockYn = nobilityStockYn;
        this.dividendPayMonth = dividendPayMonth;
    }

    public InterestedStock toEntity() {
        return InterestedStock.builder()
                .interestedStockId(InterestedStockId.builder()
                                                    .email(email)
                                                    .ticker(ticker)
                                                    .build())
                .stockNm(stockNm)
                .businessCycle(businessCycle)
                .nobilityStockYn(nobilityStockYn)
                .dividendPayMonth(dividendPayMonth)
                .build();
    }
}
