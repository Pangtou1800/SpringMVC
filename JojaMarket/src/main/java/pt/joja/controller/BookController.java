package pt.joja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pt.joja.domain.Book;

@Controller
public class BookController {

    @RequestMapping(value = "/book/{bid}", method = RequestMethod.GET)
    public String getBook(@PathVariable("bid") Integer id) {
        System.out.println("查询到了" + id + "号图书");
        return "success";
    }

    @RequestMapping(value = "/book/{bid}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bid") Integer id) {
        System.out.println("删除了" + id + "号图书");
        return "success";
    }

    @RequestMapping(value = "/book/{bid}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bid") Integer id) {
        System.out.println("更新了" + id + "号图书");
        return "success";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addBook(Book book) {
        System.out.println("添加了新的图书:" + book);
        return "success";
    }


}
