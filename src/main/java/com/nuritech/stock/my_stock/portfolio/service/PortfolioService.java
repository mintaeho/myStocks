package com.nuritech.stock.my_stock.portfolio.service;

import com.nuritech.stock.my_stock.portfolio.domain.Portfolio;
import com.nuritech.stock.my_stock.portfolio.domain.PortfolioId;
import com.nuritech.stock.my_stock.portfolio.domain.PortfolioRepository;
import com.nuritech.stock.my_stock.portfolio.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    @Transactional
    public String save(PortfolioSaveRequestDto requestDto) {
        return portfolioRepository.save(requestDto.toEntity()).getPortfolioId().getTicker();
    }

    @Transactional
    public void delete(PortfolioId portfolioId) {
        Portfolio stock = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new IllegalArgumentException("해당 종목이 없습니다. 티커="+portfolioId.getTicker()));
        portfolioRepository.delete(stock);
    }

    @Transactional(readOnly = true)
    public PortfolioResponseDto findById(PortfolioId portfolioId) {
        Portfolio entity = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new IllegalArgumentException("해당 종목이 없습니다. 티커="+portfolioId.getTicker()));
        return new PortfolioResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PortfolioListResponseDto> findAllDesc() {
        return portfolioRepository.findAllDesc().stream()
                .map(PortfolioListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PortfolioListExpandedDto> selectPortfolio(String email) {
        List<Object[]> list = portfolioRepository.selectPortfolio(email);
        PortfolioListExpandedDto dto = PortfolioListExpandedDto.builder().build();
        return dto.toDto(list);
    }

    @Transactional(readOnly = true)
    public List<PortfolioSumResponseDto> selectSumPortfolio(String email) {
        List<Object[]> list = portfolioRepository.selectSumPortfolio(email);
        PortfolioSumResponseDto dto = PortfolioSumResponseDto.builder().build();
        return dto.toDto(list);
    }

    @Transactional(readOnly = true)
    public List<SummaryPayoutPerMonthResponseDto> selectSummaryPayoutPerMonth(String email) {
        List<Object[]> list = portfolioRepository.selectSummaryPayoutPerMonth(email);
        SummaryPayoutPerMonthResponseDto dto = SummaryPayoutPerMonthResponseDto.builder().build();
        return dto.toDto(list);
    }


}
