package com.nuritech.stock.my_stock.daybook.web;

import com.nuritech.stock.my_stock.config.auth.LoginUser;
import com.nuritech.stock.my_stock.config.auth.dto.SessionUser;

import com.nuritech.stock.my_stock.daybook.dto.DaybooksResponseDto;
import com.nuritech.stock.my_stock.daybook.dto.DaybooksUpdateRequestDto;
import com.nuritech.stock.my_stock.daybook.service.DaybooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class DaybooksController {

    private final DaybooksService daybooksService;

    @GetMapping("/daybooks/v1")
    public String daybooks(Model model,
                           @LoginUser SessionUser user) {
        // ???
        model.addAttribute("daybooks", daybooksService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "daybooks/daybooks";
    }

    @GetMapping("/daybooks/v1/save")
    public String daybooksSave() {
        return "daybooks/daybooks-save.popup";
    }

    @GetMapping("/daybooks/v1/update/{id}")
    public String daybooksUpdate(@PathVariable Long id,
                                 Model model) {

        DaybooksResponseDto dto = daybooksService
                .findById(id);
        model.addAttribute("daybooks", dto);
        return "daybooks/daybooks-update.popup";
    }

}
