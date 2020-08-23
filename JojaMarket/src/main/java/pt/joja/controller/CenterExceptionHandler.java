package pt.joja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CenterExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView nullPointerHandler(NullPointerException e) {
        ModelAndView model = new ModelAndView();
        model.setViewName("myError");
        model.addObject("message", "空指针异常:" + e.getMessage());
        return model;
    }

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handleException(ArithmeticException e) {
        ModelAndView model = new ModelAndView();
        model.setViewName("myError");
        model.addObject("message", "算术异常:" + e.getMessage());
        return model;
    }

}
