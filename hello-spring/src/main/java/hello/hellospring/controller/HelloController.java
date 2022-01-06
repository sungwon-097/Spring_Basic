package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
//    @GetMapping("hello")
//    public String hello(Model model) {
//        model.addAttribute("data", "spring!!");
//        return "hello";
//    }
//
//    @GetMapping("hello-mvc")
//    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model) {
//        model.addAttribute("name", name);
//        return "hello-template";
//    }
//
//    @GetMapping("hello-string")
//    @ResponseBody // http 에서 body 에 직접 넣어주겠다는 의미
//    public String helloString(@RequestParam("name") String name){
//        return "hello" + name; // "hello spring"
//    }

    @GetMapping("hello-api") // 실무에서 대부분의 형태 그대로 사용
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); // json 파일을 만들어서 http 에 전달하겠다
        hello.setName(name);
        return hello;
    }

    static class Hello{

        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    } // json 방식 {key : val} (최근 선호하는 방식임)
}