package com.nuritech.stock.my_stock.interested.web;

import com.nuritech.stock.my_stock.config.auth.LoginUser;
import com.nuritech.stock.my_stock.config.auth.dto.SessionUser;
import com.nuritech.stock.my_stock.interested.domain.InterestedStockId;
import com.nuritech.stock.my_stock.interested.dto.InterestedStockResponseDto;
import com.nuritech.stock.my_stock.interested.service.InterestedStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class InterestedStockController {

    private final InterestedStockService interestedStockService;

    @GetMapping("/interestedStock/v1")
    public String interestedStock(Model model,
                                 @LoginUser SessionUser user) {
        //model.addAttribute("interestedStocks", interestedStockService.findAllDesc());
        model.addAttribute("interestedStocks", interestedStockService.selectInterestedStock(user.getEmail()));

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "interestedStock/interestedStock";
    }

    @GetMapping("/interestedStock/v1/save")
    public String interestedStockSave() {
        return "interestedStock/interestedStock-save.popup";
    }

    @GetMapping("/interestedStock/v1/update/{ticker}")
    public String interestedStockUpdate(@PathVariable String ticker,
                                        @LoginUser SessionUser user,
                                        Model model) {

        InterestedStockResponseDto dto = interestedStockService
                .findById(InterestedStockId.builder()
                                        .email((user != null) ? user.getEmail() : "")
                                        .ticker(ticker)
                                        .build());
        model.addAttribute("interestedStock", dto);
        return "interestedStock/interestedStock-update.popup";
    }

    @GetMapping("/companyInfo/v1/view/{ticker}")
    public String companyInfo(@PathVariable String ticker,
                              @LoginUser SessionUser user,
                              Model model) {
        InterestedStockResponseDto dto = interestedStockService
                .findById(InterestedStockId.builder()
                        .email((user != null) ? user.getEmail() : "")
                        .ticker(ticker)
                        .build());
        model.addAttribute("companyInfo", dto);
        return "interestedStock/companyInfo-view.popup";
    }

    @GetMapping("/currentInfo/v1/{ticker}")
    public String currentInfo(@PathVariable String ticker,
                              @LoginUser SessionUser user,
                              Model model) {
        String requestUrl = new StringBuilder().append("https://seekingalpha.com/api/v3/symbol_data?")
                .append("fields[]=log&fields[]=divYieldFwd&fields[]=divRate&fields[]=payoutRatio&")
                .append("fields[]=divGrowRate5&fields[]=dividendGrowth&fields[]=divYieldTtm&")
                .append("fields[]=divDistribution&fields[]=sectorname&fields[]=dividends&slugs=")
                .append(ticker)
                .toString();

        model.addAttribute("requestUrl", requestUrl);
        return "interestedStock/currentInfo-update.popup";
    }

}
