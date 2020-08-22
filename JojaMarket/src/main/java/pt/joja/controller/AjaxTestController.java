package pt.joja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pt.joja.dao.EmployeeDao;
import pt.joja.domain.Employee;

import java.util.Collection;

@Controller
public class AjaxTestController {

    @Autowired
    EmployeeDao employeeDao;

    @ResponseBody
    @RequestMapping("/ajaxGetAll")
    public Collection<Employee> ajaxGetAll() {
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }


    @RequestMapping("/testRequestBody01")
    public String testRequestBody(@RequestBody Employee body) {
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/ajaxTest01")
    public String test01(HttpEntity<String> str) {
        System.out.println(str);
        return "success";
    }

    @RequestMapping("/ajaxTest02")
    public ResponseEntity<String> test02() {
        HttpHeaders httpHeaders = new HttpHeaders();
        String body = "<h1>success</h1>";
        httpHeaders.add("Set-Cookie", "username=hahaha");
        return new ResponseEntity<>(body, httpHeaders, HttpStatus.OK);
    }
}
