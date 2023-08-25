package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    private static long visitCount = 0;

    @GetMapping("/static-hello")
    public String hello() {
        return "hello.html";
    }
    //1. URL에 localhost:8080/hello.html 로 접근한다.
    //2. thymeleaf를 주석처리하고 localhost:8080/static-hello 로 접근한다.
    //3. thymeleaf를 주석처리안하고 접근방법
    @GetMapping("/html/redirect")
    public String htmlStatic() {
        return "redirect:/hello.html";
    }
    //4. 정적인 페이지도 templates에 html 페이지 넣어도 된다. 안되는 것 아님 -> return으로 이름만 넣으면 된다.
    @GetMapping("/html/templates")
    public String htmlTemplates() {
        return "hello";
    }

    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model) {
        visitCount++;
        //                        식별자, 데이터변수
        model.addAttribute("visits", visitCount);
        return "hello-visit";
    }



}
