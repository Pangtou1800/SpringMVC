package pt.joja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes(value = {"msg"}, types = {Integer.class})
@Controller
public class OutputSessionController {

    @RequestMapping("/output05")
    public ModelAndView output05() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        ModelMap modelMap = modelAndView.getModelMap();
        modelMap.addAttribute("msg", "你好，ModelAndView!");
        modelMap.addAttribute("counter", 18);

        return modelAndView;
    }

}
