package com.nuritech.stock.my_stock.interested.dto;

import com.nuritech.stock.my_stock.interested.domain.InterestedStock;
import com.nuritech.stock.my_stock.portfolio.dto.PortfolioListExpandedDto;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class InterestedStockListExapndedDto {
    private String email;
    private String ticker;
    private String stockNm;
    private String businessCycle;
    private String sector;
    private BigDecimal currentPrice;
    private BigDecimal payoutRatio;
    private BigDecimal annualPayout;
    private BigDecimal divYield;
    private String dividendPayMonth;
    private BigDecimal highestPrice;
    private BigDecimal lowerPrice;
    private BigDecimal avgPrice;
    private BigDecimal under10Price;
    private BigDecimal under20Price;
    private BigDecimal under30Price;
    private String buyingYn;
    private String nobilityStockYn;
    private LocalDateTime modifiedDate;

    @Builder
    public InterestedStockListExapndedDto(String ticker,
                                    String stockNm,
                                    String businessCycle,
                                    String sector,
                                    BigDecimal currentPrice,
                                    BigDecimal payoutRatio,
                                    BigDecimal annualPayout,
                                    BigDecimal divYield,
                                    String dividendPayMonth,
                                    BigDecimal highestPrice,
                                    BigDecimal lowerPrice,
                                    BigDecimal avgPrice,
                                    BigDecimal under10Price,
                                    BigDecimal under20Price,
                                    BigDecimal under30Price,
                                    String buyingYn,
                                    String nobilityStockYn) {
        this.ticker = ticker;
        this.stockNm =  stockNm;
        this.businessCycle = businessCycle;
        this.sector = sector;
        this.currentPrice = currentPrice;
        this.payoutRatio = payoutRatio;
        this.annualPayout = annualPayout;
        this.divYield = divYield;
        this.dividendPayMonth = dividendPayMonth;
        this.highestPrice = highestPrice;
        this.lowerPrice = lowerPrice;
        this.avgPrice = avgPrice;
        this.under10Price = under10Price;
        this.under20Price = under20Price;
        this.under30Price = under30Price;
        this.buyingYn = buyingYn;
        this.nobilityStockYn = nobilityStockYn;
    }

    public List<InterestedStockListExapndedDto> toDto(List<Object[]> objects) {
        List<InterestedStockListExapndedDto> list = new ArrayList<InterestedStockListExapndedDto>();
        for(Object[] obj : objects) {
            list.add(InterestedStockListExapndedDto.builder()
                    .ticker((String) obj[0])
                    .stockNm((String) obj[1])
                    .businessCycle((String) obj[2])
                    .sector((String) obj[3])
                    .currentPrice((BigDecimal) obj[4])
                    .payoutRatio((BigDecimal) obj[5])
                    .annualPayout((BigDecimal) obj[6])
                    .divYield((BigDecimal) obj[7])
                    .dividendPayMonth((String) obj[8])
                    .highestPrice((BigDecimal) obj[9])
                    .lowerPrice((BigDecimal) obj[10])
                    .avgPrice((BigDecimal) obj[11])
                    .under10Price((BigDecimal) obj[12])
                    .under20Price((BigDecimal) obj[13])
                    .under30Price((BigDecimal) obj[14])
                    .buyingYn((String) obj[15])
                    .nobilityStockYn((String) obj[16])
                    .build());
        }
        return list;
    }


}
