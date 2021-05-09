package com.nuritech.stock.my_stock.portfolio.domain;

import com.nuritech.stock.my_stock.portfolio.dto.PortfolioListExpandedDto;
import com.nuritech.stock.my_stock.portfolio.dto.PortfolioListResponseDto;
import com.nuritech.stock.my_stock.portfolio.dto.PortfolioSumResponseDto;
import com.nuritech.stock.my_stock.scraping.domain.Stock;
import com.nuritech.stock.my_stock.scraping.domain.StockRepository;
import com.nuritech.stock.my_stock.scraping.dto.StockDto;
import com.nuritech.stock.my_stock.scraping.dto.StockListDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PortfolioRepositoryTest {

    @Autowired
    PortfolioRepository portfolioRepository;

    private final String email = "test@gmail.com";
    private final String ticker = "TEST";

    @AfterEach      // junit5
    public void cleanup() {
        portfolioRepository.deleteById(PortfolioId.builder()
                .email(email)
                .ticker(ticker)
                .build());
    }

    @Test
    public void portfolio_저장() {

        LocalDateTime now = LocalDateTime.of(2021,5,8,0,0,0);

        portfolioRepository.save(Portfolio.builder()
                .portfolioId(PortfolioId.builder()
                        .email(email)
                        .ticker(ticker)
                        .build())
                .build());

        Optional<Portfolio> portfolio = portfolioRepository.findById(PortfolioId.builder()
                .email(email)
                .ticker(ticker)
                .build());

        assertThat(portfolio.get().getPortfolioId().getTicker()).isEqualTo(ticker);
        assertThat(portfolio.get().getCreatedDate()).isAfter(now);
        assertThat(portfolio.get().getModifiedDate()).isAfter(now);
    }

    @Test
    public void findById_실행() {
        portfolio_저장();
        Optional<Portfolio> entity = portfolioRepository.findById(PortfolioId.builder()
                .email(email)
                .ticker(ticker)
                .build());
        assertThat(entity.get().getPortfolioId().getTicker()).isEqualTo(ticker);

    }

    @Test
    public void findAllDesc_실행() {
        portfolio_저장();
        // 리스트 조회
        boolean isExistsData = false;
        List<PortfolioListResponseDto> portfolioListResponseDtoList = portfolioRepository.findAllDesc().stream()
                .map(PortfolioListResponseDto::new)
                .collect(Collectors.toList());
        for(PortfolioListResponseDto responseDto : portfolioListResponseDtoList) {
            if (ticker == responseDto.getTicker()) isExistsData = true;
        }
        assertThat(isExistsData);
    }

    @Test
    public void selectPortfolio_실행() {
        portfolio_저장();
        List<Object[]> list = portfolioRepository.selectPortfolio(email);
        PortfolioListExpandedDto dto = PortfolioListExpandedDto.builder().build();
        List<PortfolioListExpandedDto> portfolioListExpandedDtoList = dto.toDto(list);
        boolean isExistsData = false;
        for(PortfolioListExpandedDto responseDto : portfolioListExpandedDtoList) {
            if (ticker == responseDto.getTicker()) isExistsData = true;
        }
        assertThat(isExistsData);
    }

    @Test
    public void selectSumPortfolio_실행() {
        portfolio_저장();
        List<Object[]> list = portfolioRepository.selectSumPortfolio(email);
        PortfolioSumResponseDto dto = PortfolioSumResponseDto.builder().build();
        List<PortfolioSumResponseDto> portfolioSumResponseDtoList = dto.toDto(list);
        assertThat(portfolioSumResponseDtoList.size()==1);
    }
}
