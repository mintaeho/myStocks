package com.nuritech.stock.my_stock.company.web;

import com.nuritech.stock.my_stock.config.auth.LoginUser;
import com.nuritech.stock.my_stock.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CompanyInfoController {

    @GetMapping("/company-info/v1")
    public String companyInfo(Model model,
                              @LoginUser SessionUser user) {
        model.addAttribute("userName", (user != null)?user.getName():"");
        return "company-info/company-info";
    }

}
