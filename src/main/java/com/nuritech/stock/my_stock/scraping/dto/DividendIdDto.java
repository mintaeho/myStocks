package com.nuritech.stock.my_stock.scraping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class DividendIdDto {
    private List<DividendAttributeDto> data;
}
