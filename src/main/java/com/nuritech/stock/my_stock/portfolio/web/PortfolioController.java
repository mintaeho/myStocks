package com.nuritech.stock.my_stock.portfolio.web;

import com.nuritech.stock.my_stock.config.auth.LoginUser;
import com.nuritech.stock.my_stock.config.auth.dto.SessionUser;
import com.nuritech.stock.my_stock.interested.domain.InterestedStockId;
import com.nuritech.stock.my_stock.interested.dto.InterestedStockResponseDto;
import com.nuritech.stock.my_stock.portfolio.domain.PortfolioId;
import com.nuritech.stock.my_stock.portfolio.dto.PortfolioResponseDto;
import com.nuritech.stock.my_stock.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping("/portfolio/v1")
    public String portfolio(Model model,
                            @LoginUser SessionUser user) {

        log.debug(">> user email = {}", user.getEmail());
        //model.addAttribute("portfolio", portfolioService.findAllDesc());
        model.addAttribute("portfolio", portfolioService.selectPortfolio(user.getEmail()));
        model.addAttribute("portfolioSum", portfolioService.selectSumPortfolio(user.getEmail()));

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "portfolio/portfolio";
    }

    @GetMapping("/portfolio/v1/save")
    public String portfolioSave() {
        return "portfolio/portfolio-save";
    }

    @GetMapping("/portfolio/v1/update/{ticker}")
    public String interestedStockUpdate(@PathVariable String ticker,
                                        @LoginUser SessionUser user,
                                        Model model) {

        PortfolioResponseDto dto = portfolioService
                .findById(PortfolioId.builder()
                        .email((user != null) ? user.getEmail() : "")
                        .ticker(ticker)
                        .build());
        model.addAttribute("portfolio", dto);
        return "portfolio/portfolio-update";
    }

}
