package pt.joja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam("username") String username, @RequestParam("headerImg") MultipartFile[] files, Model model, HttpServletRequest request) {
        for (MultipartFile file : files) {
            if (!file.isEmpty())
                try {

                    File newFile = new File(request.getServletContext().getRealPath("/upload/" + file.getOriginalFilename()));
                    file.transferTo(newFile);
                    model.addAttribute("message", "上传成功！");
                } catch (IOException e) {
                    e.printStackTrace();
                    model.addAttribute("message", "上传失败：" + e.getMessage());
                }
        }
        return "forward:/index.jsp";
    }
}
