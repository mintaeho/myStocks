package com.nuritech.stock.my_stock.interested.dto;

import com.nuritech.stock.my_stock.interested.domain.InterestedStock;
import com.nuritech.stock.my_stock.interested.domain.InterestedStockId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class InterestedStockSaveRequestDto {
    private String email;
    private String ticker;
    private String stockNm;
    private String businessCycle;
    private String sector;
    private String nobilityStockYn;
    private BigDecimal divYield;
    private BigDecimal annualPayout;
    private BigDecimal payoutRatio;
    private BigDecimal fiveYearGrowthRate;
    private String dividendGrowth;
    private String companyInfo;

    public void setEmail(String email) {
        this.email = email;
    }

    @Builder
    public InterestedStockSaveRequestDto(String email,
                                         String ticker,
                                         String stockNm,
                                         String businessCycle,
                                         String sector,
                                         String nobilityStockYn,
                                         BigDecimal divYield,
                                         BigDecimal annualPayout,
                                         BigDecimal payoutRatio,
                                         BigDecimal fiveYearGrowthRate,
                                         String dividendGrowth,
                                         String companyInfo) {
        this.email = email;
        this.ticker = ticker;
        this.stockNm = stockNm;
        this.businessCycle = businessCycle;
        this.sector = sector;
        this.nobilityStockYn = nobilityStockYn;
        this.divYield = divYield;
        this.annualPayout = annualPayout;
        this.payoutRatio = payoutRatio;
        this.fiveYearGrowthRate = fiveYearGrowthRate;
        this.dividendGrowth = dividendGrowth;
        this.companyInfo = companyInfo;
    }

    public InterestedStock toEntity() {
        return InterestedStock.builder()
                .interestedStockId(InterestedStockId.builder()
                                                    .email(email)
                                                    .ticker(ticker)
                                                    .build())
                .stockNm(stockNm)
                .businessCycle(businessCycle)
                .sector(sector)
                .nobilityStockYn(nobilityStockYn)
                .divYield(divYield)
                .annualPayout(annualPayout)
                .payoutRatio(payoutRatio)
                .fiveYearGrowthRate(fiveYearGrowthRate)
                .dividendGrowth(dividendGrowth)
                .companyInfo(companyInfo)
                .build();
    }
}
