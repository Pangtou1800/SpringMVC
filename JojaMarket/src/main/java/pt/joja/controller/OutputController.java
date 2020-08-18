package pt.joja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class OutputController {

    @RequestMapping("/output01")
    public String output01(Map<String, Object> map) {
        org.springframework.validation.support.BindingAwareModelMap e;
        map.put("msg", "你好");
        System.out.println(map.getClass());
        return "success";
    }

    @RequestMapping("/output02")
    public String output02(Model model) {
        model.addAttribute("msg", "你好，Model！");
        System.out.println(model.getClass());
        return "success";
    }

    @RequestMapping("/output03")
    public String output03(ModelMap modelMap) {
        modelMap.addAttribute("msg", "你好，ModelMap！");
        System.out.println(modelMap.getClass());
        return "success";
    }

    @RequestMapping("/output04")
    public ModelAndView output04() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        ModelMap modelMap = modelAndView.getModelMap();
        modelMap.addAttribute("msg", "你好，ModelAndView!");
        return modelAndView;
    }

}
