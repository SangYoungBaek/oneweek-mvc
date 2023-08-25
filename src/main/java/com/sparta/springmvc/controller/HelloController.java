package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class HelloController {
    // URL은 중복될 수 있다.
    // 메서드 중복은 안됨
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        //view 정보를 반환할때 return에 담아서 보낸다 그래서 @ResponsBody를 붙여서 바디에 보낼꺼라는 것을 써줌
        return "Hello World!!";
    }

    @GetMapping("/get")
    @ResponseBody
    public String get() {
        return "GET Method 요청";
    }

    @PostMapping("/post")
    @ResponseBody
    public String post() {
        return "POST Method 요청";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put() {
        return "PUT Method 요청";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete() {
        return "DELETE Method 요청";
    }
}
