package com.sparta.springmvc.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {
    // Content-Type : text/html
    // Response Body
    // {"name":"Robbie", "age":95}
    // 이렇게 반환됨
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    // Content-Type : application/json
    // Response Body
    // {"name":"Robbie", "age":95}
    // Spring은 자동으로 객체를 JSON 형식으로 반환함.
    @GetMapping("/json/class")
    @ResponseBody
    public Star helloClassJson() {
        return new Star("Robbie", 95);
    }
}
