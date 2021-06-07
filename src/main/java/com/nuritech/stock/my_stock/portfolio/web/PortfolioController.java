package com.nuritech.stock.my_stock.portfolio.web;

import com.nuritech.stock.my_stock.config.auth.LoginUser;
import com.nuritech.stock.my_stock.config.auth.dto.SessionUser;
import com.nuritech.stock.my_stock.interested.domain.InterestedStockId;
import com.nuritech.stock.my_stock.interested.dto.InterestedStockResponseDto;
import com.nuritech.stock.my_stock.portfolio.domain.PortfolioId;
import com.nuritech.stock.my_stock.portfolio.dto.PortfolioResponseDto;
import com.nuritech.stock.my_stock.portfolio.dto.SummaryPayoutPerMonthResponseDto;
import com.nuritech.stock.my_stock.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

        List <SummaryPayoutPerMonthResponseDto> summaryPayout =  portfolioService.selectSummaryPayoutPerMonth(user.getEmail());

        // 월별배당금 계산
        Map dividendPayMonthMap = new HashMap<String, BigDecimal>();
        summaryPayout.forEach(list -> {
            log.debug("list.getDividendPayMonth() : {}", list.getDividendPayMonth());
            log.debug("list.getPayoutMonth() : {}", list.getPayoutMonth());
            String dividendPayMonthStr = list.getDividendPayMonth();
            if ( "per months".equals(dividendPayMonthStr)) {
                for (int i = 0; i < 12; i++) {
                    collectDividendPayoutMonthly(dividendPayMonthMap,
                            i+1,
                            ObjectUtils.defaultIfNull(list.getPayoutMonth(), new BigDecimal("0")) );
                }
            }
            else {
                if ( dividendPayMonthStr != null ) {
                    String[] dividendPayMonthArr = dividendPayMonthStr.split(",");
                    for (int i = 0; i < dividendPayMonthArr.length; i++) {
                        collectDividendPayoutMonthly(dividendPayMonthMap,
                                Integer.parseInt(dividendPayMonthArr[i].trim()),
                                ObjectUtils.defaultIfNull(list.getPayoutMonth(), new BigDecimal("0")));
                    }
                }
            }
        });

        log.debug("dividendPayMonthMap={}", dividendPayMonthMap.toString());

        model.addAttribute("summaryPayout", summaryPayout);
        model.addAttribute("summaryPayoutMonthly", dividendPayMonthMap);


        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "portfolio/portfolio";
    }

    private Map collectDividendPayoutMonthly(Map dividendPayMonthMap,
                                              Integer key,
                                              BigDecimal value) {
        log.debug("key={}, value={}", key, value);
        if (dividendPayMonthMap.containsKey(key)) {
            dividendPayMonthMap.put(key, value.add((BigDecimal) dividendPayMonthMap.get(key)));
        } else {
            dividendPayMonthMap.put(key, value);
        }

        return dividendPayMonthMap;
    }

    @GetMapping("/portfolio/v1/save")
    public String portfolioSave() {
        return "portfolio/portfolio-save.popup";
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
        return "portfolio/portfolio-update.popup";
    }

}
