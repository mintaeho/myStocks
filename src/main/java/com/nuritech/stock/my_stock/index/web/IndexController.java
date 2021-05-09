package com.nuritech.stock.my_stock.index.web;


import com.nuritech.stock.my_stock.config.auth.LoginUser;
import com.nuritech.stock.my_stock.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    //private final HttpSession httpSession;

    // 로그인 되어 있으면 메인 페이지로
    // 메인 페이지는 나의 포트폴리오 화면
    // 로그인 안되어 있으면 로그인 페이지로 이동

    @GetMapping("/")
    public String index(Model model,
                        @LoginUser SessionUser user) {

        System.out.println(">>>>>>>>>>> call here...");
        if (user != null) {
            model.addAttribute("userName", user.getName());
            //return "index";
            return "redirect:/portfolio/v1";
        }
        return "login";
    }


}
