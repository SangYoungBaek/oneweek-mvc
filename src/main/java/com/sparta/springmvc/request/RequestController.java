package com.sparta.springmvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request")
public class RequestController {
    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // [Request sample]
    // GET http://localhost:8080/hello/request/star/Robbie/age/95
    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)
    {   //@PathVariable(required = false) 도 있음
        //lient로 부터 값을 전달 받지 못한 해당 변수는 null로 초기화
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }
    // RequestParam 방식, 쿼리스트링
    // [Request sample]
    // GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }
//    @GetMapping("/form/param")
//    @ResponseBody
//    public String helloGetRequestParam(@RequestParam String name, int age) {
//        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
//    }
    // 생략은 해도 되는데, 필수적으로 넣어줘야한다.
//   @GetMapping("/form/param")
//    @ResponseBody
//    public String helloGetRequestParam(@RequestParam(required = false) String name, int age) {
//        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
//    }
    // 클라이언트에서 전달받은 값이 없어도 오류가 발생하지 않는다. required = false
    // [Request sample]
    // POST http://localhost:8080/hello/request/form/param
    // Header
    //  Content type: application/x-www-form-urlencoded
    // Body
    //  name=Robbie&age=95
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }
}