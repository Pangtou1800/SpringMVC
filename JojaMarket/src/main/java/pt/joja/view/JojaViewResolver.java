package pt.joja.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class JojaViewResolver implements ViewResolver, Ordered {

    private int order;

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {

        if (viewName.startsWith("joja:")) {
            return new JojaView();
        } else {
            // 不能处理返回null即可
            return null;
        }
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }
}
