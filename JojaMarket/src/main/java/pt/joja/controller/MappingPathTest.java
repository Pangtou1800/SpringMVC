package pt.joja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MappingPathTest {

    @RequestMapping("/antTest01")
    public String path01() {
        System.out.println("path01");
        return "success";
    }

    @RequestMapping("/antTest0?")
    public String path02() {
        System.out.println("path02");
        return "success";
    }

    @RequestMapping("/antTest0*")
    public String path03() {
        System.out.println("path03");
        return "success";
    }

    @RequestMapping("/antTest04/**")
    public String path04() {
        System.out.println("path04");
        return "success";
    }

    @RequestMapping("/antTest05/{id}")
    public String path05(@PathVariable("id") String id) {
        System.out.println("path05:"+ id);
        return "success";
    }

}
