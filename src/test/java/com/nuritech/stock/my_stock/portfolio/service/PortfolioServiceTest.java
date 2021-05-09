package com.nuritech.stock.my_stock.portfolio.service;

import com.nuritech.stock.my_stock.portfolio.domain.PortfolioId;
import com.nuritech.stock.my_stock.portfolio.dto.*;
import com.nuritech.stock.my_stock.scraping.dto.StockDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PortfolioServiceTest {

    private final String email = "test@gmail.com";
    private final String ticker = "TEST";

    @Autowired
    PortfolioService portfolioService;

    @AfterEach      // junit5
    public void cleanup() {
        try {
            portfolioService.delete(PortfolioId.builder()
                    .email(email)
                    .ticker(ticker)
                    .build());
        } catch (IllegalArgumentException ire) {
            log.debug(ire.getLocalizedMessage());
        }
        ;
    }

    @Test
    public void portfolioSave_실행() {
        // save
        PortfolioSaveRequestDto requestDto = PortfolioSaveRequestDto.builder()
                .email(email)
                .ticker(ticker)
                .build();

        String result = portfolioService.save(requestDto);
        assertThat(result).isEqualTo(ticker);
    }

    @Test
    public void findById_실행() {
        portfolioSave_실행();
        // find by id
        PortfolioResponseDto responseDto = portfolioService.findById(PortfolioId.builder()
                .email(email)
                .ticker(ticker)
                .build());

        assertThat(responseDto.getTicker()).isEqualTo(ticker);
    }

    @Test
    public void findAllDesc_실행() {
        portfolioSave_실행();
        // find by desc
        List<PortfolioListResponseDto> portfolioListResponseDtoList = portfolioService.findAllDesc();
        assertThat(portfolioListResponseDtoList.size()>0);
        boolean isExistsData = false;
        for(PortfolioListResponseDto dto : portfolioListResponseDtoList) {
            if(ticker.equals(dto.getTicker())) isExistsData = true;
        }
        assertThat(isExistsData);
    }

    @Test
    public void selectPortfolio_실행() {
        portfolioSave_실행();
        List<PortfolioListExpandedDto> selectList = portfolioService.selectPortfolio(email);
        for(PortfolioListExpandedDto dto : selectList) {
                log.debug("dto.toString() = {}", dto.toString());
        }
        assertThat(selectList.size()>0);
    }

    @Test
    public void selectSumPortfolio_실행() {
        portfolioSave_실행();
        List<PortfolioSumResponseDto> selectList = portfolioService.selectSumPortfolio(email);
        for(PortfolioSumResponseDto dto : selectList) {
            log.debug("dto.toString() = {}", dto.toString());
        }
        assertThat(selectList.size()==1);
    }



}
