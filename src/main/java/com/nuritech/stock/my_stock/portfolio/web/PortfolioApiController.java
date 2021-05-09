package com.nuritech.stock.my_stock.portfolio.web;

import com.nuritech.stock.my_stock.config.auth.LoginUser;
import com.nuritech.stock.my_stock.config.auth.dto.SessionUser;

import com.nuritech.stock.my_stock.portfolio.domain.PortfolioId;
import com.nuritech.stock.my_stock.portfolio.dto.PortfolioListExpandedDto;
import com.nuritech.stock.my_stock.portfolio.dto.PortfolioListResponseDto;
import com.nuritech.stock.my_stock.portfolio.dto.PortfolioResponseDto;
import com.nuritech.stock.my_stock.portfolio.dto.PortfolioSaveRequestDto;
import com.nuritech.stock.my_stock.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PortfolioApiController {

    private final PortfolioService portfolioService;

    @PostMapping("/api/v1/portfolio")
    public String save(@RequestBody PortfolioSaveRequestDto requestDto,
                       @LoginUser SessionUser user) {
        if (user != null) requestDto.setEmail(user.getEmail());
        return portfolioService.save(requestDto);
    }

    @DeleteMapping("/api/v1/portfolio/{ticker}")
    public String delete(@PathVariable String ticker,
                       @LoginUser SessionUser user) {
        portfolioService.delete(PortfolioId.builder()
                                        .email((user != null) ? user.getEmail() : "")
                                        .ticker(ticker)
                                        .build());
        return ticker;
    }

    @GetMapping("/api/v1/portfolio/{ticker}")
    public PortfolioResponseDto findById(@PathVariable String ticker,
                                         @LoginUser SessionUser user) {

        return portfolioService.findById(PortfolioId.builder()
                .email((user != null) ? user.getEmail() : "")
                .ticker(ticker)
                .build());
    }

    @GetMapping("/api/v1/portfolio/list")
    public List<PortfolioListResponseDto> findAll() {
        return portfolioService.findAllDesc();
    }


}
