# SpringMVC

    由Spring来实现MVC交互

## 第一节 简介

* Spring为展现层提供的基于MVC设计理念的优秀的Web框架，是目前最主流的MVC框架之一
* Spring3.0之后全面超越Struts2
* SpringMVC通过一套MVC注解，让POJO称为处理请求的控制器，而无需实现任何接口
* 支持REST风格的URL请求
* 采用了松散耦合和可插拔组件结构，比其他MVC框架更具扩展和灵活性

### Spring划分的MVC：

                                            DelegateRequest
    -- Incoming Request -> Front Controller --------------> Controller HandleRequest
    <- Returing Response -    前端控制器     <- Model     --   控制器    CreateModel
                                ↑   |                                    ↑ |
                                |   Model                             返回  调用
                         Return |   | Render Response             数据模型   业务模型
                        Control |   | 选择视图渲染                        |  |
                                |   ↓                                    |  ↓
                            View Template                             Model
                                视图模板                                 模型

## 第二节 环境搭建

    2.1 导包

        - Spring核心容器模块

            core
            beans
            context
            expression

        - Spring AOP模块

            aop

            - net.sf.cglig
            - aopalliance
            - aspectj.weaver

        - Spring Web模块

            web
            webmvc

    2.2 配置一个SpringMVC的前端控制器

        <servlet>
            <servlet-name>springDispatcherServlet</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:applicationContext.xml</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup> - 服务器启动时创建，值越小优先级越高
        </servlet>

        <servlet-mapping>
            <servlet-name>springDispatcherServlet</servlet-name>
            <url-pattern>/</url-pattern> - 拦截所有请求
                                           /* 范围更大，还会拦截到*.jsp，此处要放行
        </servlet-mapping>

    2.3 Hello Spring MVC

        - 创建一个POJO类，标记为@Controller
        - 创建一个返回值为String的任意方法，注解关联到某个地址

        @Controller
        public class MyFirstController {

            @RequestMapping("/hello")
            public String myFirstRequest() {
                System.out.println("请求收到了...");
                return "/WEB-INF/pages/success.jsp";
            }
        }

        ※可以配置一个视图解析器来帮助拼接地址

        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/WEB-INF/pages/"/>
            <property name="suffix" value=".jsp"/>
        </bean>

        -- not even need an id -- 

## 第三节 Hello Spring MVC 运行细节

    3.1 运行流程

        1. 客户端发送链接http://localhost:8080/JojaMarket/hello

        2. Tomcat服务器收到请求

        3. SpringMVC的前端控制器收到了所有请求 - springDispatcherServlet

        

        4. 将请求地址与@RequestMapping标注的所有地址进行匹配

        5. 前端控制器找到目标处理器类和目标方法，利用反射执行目标方法

        6. 方法执行完成以后有一个返回值，用视图解析器拼串得到完整地址，

           SpringMVC认为该地址就是转发目标页面

        7. 前端控制器转发到该目标页面

    3.2 RequestMapping

        告诉SpringMVC方法用来处理什么请求
        参数里的/可以省略，省略时也是默认从当前项目根目录下开始，但是推荐添加

    3.3 如果不指定配置文件路径，默认寻找：
        /WEB-INF/[springDispatcherServlet]-servlet.xml
                            ↑
            就是配置的DispatcherServlet的serlvet名

    3.4 路径匹配机制

        1. Tomcat自身的大web.xml中，有一个defaultServlet是url-pattern=/

           defaultServlet用来处理静态资源

        2. 前端控制器url-pattern=/

        3. 所有项目内的web.xml都是继承于大web.xml，

           所以相当于禁用了tomcat服务器中的defaultServlet，
           静态资源访问也会来到DispatcherServlet中

        4. Tomcat自身的大web.xml中，还有一个jspServlet是url-pattern=*.jsp

           /*将其覆盖之后，jsp也会不能访问

        ※ / 也是配合REST风格的处理

## 第四节 @RequestMapping详解

    4.1 标记在类定义上 和 标记在方法上

        标记在类上：

            - 提供初步的请求映射信息
            - 相对于Web应用的根目录计算

        标记在方法上：

            - 提供进一步的细分映射信息
            - 相对于类上的路径计算

    4.2 属性

        1. 映射请求参数、请求方法、请求头

            method
                - 限定请求方式：GET|POST|PUT|DELETE...

                method = RequestMethod.POST 只接受POST ※默认全部接受

            params
                - 规定请求参数

                必须带上username
                @RequestMapping(value="/handle03", params={"username"})

                不可以带上username
                @RequestMapping(value="/handle031", params={"!username"})

                username的值必须是123
                @RequestMapping(value="/handle031", params={"username=123"})

                没带username或username的值必须不是123
                @RequestMapping(value="/handle031", params={"username!=123"})

                参数必须满足所有规则
                @RequestMapping(value="/handle03", params={"username","password","age"})

            headers
                - 规定请求头
                  和params一样可以写简单的格式要求

                @RequestMapping(value="/handle04",headers={"User-Agent!=Mozilla/5.0.."}
                规定某个浏览器不可以访问

            consumes
                - 只接受内容类型是哪种的请求，即请求头中的Content-Type

            produces
                - 告诉浏览器返回的内容是什么，即想响应头中加Content-Type

    4.3 Ant风格的地址匹配

        通配符：
            - ？：匹配文件名中的一个字符（0个多个都不行）

            - * ：匹配文件名中的任意字符 或 一层路径

            - ** ：匹配多层路径

            模糊 VS 精确时，精确优先

            精确 > ? > * > **

    4.4 @PathVariable映射URL绑定的占位符

        将URL中匹配到的参数穿到控制器中

        @RequestMapping("/antTest05/{id}")
        public String path05(@PathVariable("id") String id) {
            System.out.println("path05:"+ id);
            return "success";
        }
