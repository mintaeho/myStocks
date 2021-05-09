package com.nuritech.stock.my_stock.scraping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RealtimeIdDto {
    private String type;
    private String id;
    private RealtimeAttributeDto attributes;
}
