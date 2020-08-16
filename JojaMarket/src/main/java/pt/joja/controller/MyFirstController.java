package pt.joja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstController {

    @RequestMapping("/hello")
    public String myFirstRequest() {
        System.out.println("请求收到了...");
        return "success";
    }
}
