package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    // 렌더링 페이지
    @GetMapping("hello")
    public String hello(Model model){ // 모델에서 데이터를 받아서 뷰에 전달
        model.addAttribute("data","hello");
        return "hello"; // 화면 이름 hello.html -> Spring boot의 타임리프가 알아서 찾아줌.
    }
}
