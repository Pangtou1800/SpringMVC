package pt.joja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pt.joja.exception.UsernameNotFoundException;

@Controller
public class ExceptionTestController {

    @RequestMapping("/exception01")
    public String exception01(Integer i) {
        System.out.println(10 / i);
        return "success";
    }

    @RequestMapping("/exception02")
    public String exception02(String username) {
        if (!"admin".equals(username)) {
            System.out.println("不是admin");
            throw new UsernameNotFoundException();
        }
        return "success";
    }

    @RequestMapping("/exception03")
    public String exception03(String username) {
        Integer.parseInt(username);
        return "success";
    }


}
