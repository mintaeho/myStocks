package com.nuritech.stock.my_stock.exercise.book.web;

import com.nuritech.stock.my_stock.exercise.book.service.PostsService;
import com.nuritech.stock.my_stock.exercise.book.web.dto.PostsResponseDto;
import com.nuritech.stock.my_stock.config.auth.LoginUser;
import com.nuritech.stock.my_stock.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/posts/index")
    public String postsindex(Model model,
                        @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        System.out.println("............... here call..");
        /*
         * 아래 코드처럼 가져오던 SessionUser를 LoginUserArgumentResolver를 적용
         * 파라미터에 @LoginUser만 사용하면 세션정보를 가져올 수 있게 되므로
         * 아래 코드처럼 반복해서 사용하는 코드 제거 가능
         */
        //SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "posts/index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts/posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts/posts-update";
    }
}
