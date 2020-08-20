package pt.joja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyViewResolverController {

    @RequestMapping("handlePlus")
    public String handlePlus(Model model) {
        List<String> vname= new ArrayList<>();
        List<String> images= new ArrayList<>();
        vname.add("Video1");
        vname.add("Video2");
        images.add("Picture1");
        model.addAttribute("videos", vname);
        model.addAttribute("images", images);
        return "joja:/jojaWhatever";
    }
}
