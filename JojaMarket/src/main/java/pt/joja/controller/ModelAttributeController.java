package pt.joja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pt.joja.domain.Book2;

@Controller
public class ModelAttributeController {

    private Model model;

    private Book2 book2;

    /**
     * 以图书修改为例
     * <p>
     * 1. 页面上传进来了关于图书的所有信息
     * 2. Servlet收到请求后，调用DAO
     * 3. 常见的处理只会修改一部分字段, 不修改的字段不会在页面上提供修改输入框
     * 4. 没有传进来的字段会为null，所以不可以直接调用全字段更新的SQL
     * 5.
     *
     * @return
     */
    @RequestMapping("modelAttribute01")
    public String modelAttribute01(@ModelAttribute("key01") Book2 book2, Model model) {

        System.out.println(book2);
        System.out.println(this.model == model);
        System.out.println(this.book2 == book2);
        
        return "success";
    }

    @ModelAttribute
    public void modelAttributePre(Model model) {
        System.out.println("pre method...");
        Book2 book2 = new Book2();
        book2.setBookName("西游记");
        book2.setAuthor("吴承恩");
        model.addAttribute("key01", book2);
        this.model = model;
        this.book2 = book2;
    }
}
