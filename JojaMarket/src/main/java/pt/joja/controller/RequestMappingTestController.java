package pt.joja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/haha")
@Controller
public class RequestMappingTestController {

    @RequestMapping("/handle01")
    public String handle01() {
        System.out.println("[RequestMappingTestController][handle01]");
        return "success";
    }

    @RequestMapping(value="/handle02",method = RequestMethod.POST)
    public String handle02() {
        return "success";
    }

    @RequestMapping(value="/handle03", params={"username","password","age"})
    public String handle03() {
    return "success";
    }

    @RequestMapping(value="/handle031", params={"!username"})
    public String handle031() {
        return "success";
    }

    @RequestMapping(value="/handle032", params={"!username"})
    public String handle032() {
        return "success";
    }

    @RequestMapping(value="/handle04",headers={"User-Agent!=Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36"})
    public String handle04() {
        return "success";
    }

}
