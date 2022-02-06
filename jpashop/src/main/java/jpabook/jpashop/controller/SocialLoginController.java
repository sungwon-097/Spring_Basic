package jpabook.jpashop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class SocialLoginController {

    @GetMapping("/naver/auth?code={code}&state={state}")
    public @ResponseBody String naverLogin(@PathVariable String code, @PathVariable String state){
        return code;
    }
}