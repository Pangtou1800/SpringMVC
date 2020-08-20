package pt.joja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {
    @RequestMapping("login")
    public String toLogin() {
        return "Login";
    }


    @RequestMapping("hello01")
    public String hello() {
        return "index2";
    }

    @RequestMapping("hello02")
    public String hello2() {
        return "forward:/index2.jsp";
    }

    @RequestMapping("hello03")
    public String hello3() {
        return "forward:/hello02";
    }

    @RequestMapping("hello04")
    public String hello4() {
        return "redirect:/hello02";
    }


    @RequestMapping("handle01")
    public String handle01(String username) {
        System.out.println(username);
        return "success";
    }

    @RequestMapping("handle02")
    public String handle02(@RequestParam(value = "username", required = false, defaultValue = "pangtou1404") String user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping("handle03")
    public String handle03(@RequestHeader("User-Agent") String userAgent) {
        System.out.println(userAgent);
        return "success";
    }

    @RequestMapping("handle04")
    public String handle04(@CookieValue("JSESSIONID") String jId) {
        System.out.println(jId);
        return "success";
    }

    @RequestMapping("handle05")
    public String handle05(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getCharacterEncoding());
        request.setAttribute("requestAttr", "请求域的值！");
        httpSession.setAttribute("sessionAttr", "Session域的值！");
        return "success";
    }

}
