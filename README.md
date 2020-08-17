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

## 第五节 REST风格

    Representational State Transfer - 表现层/资源状态转化

    ·资源 Resource : 网络上的一个实体
        

        - URI即为每一个资源的独一无二的是识别符

    ·表现层 Representation ： 把资源具体呈现出来的形式

        - HTML、XML、JSON 乃至图片、二进制格式等

    ·状态转化 State Transfer ： 每发一个请求，就代表了客户端和服务器的一次交互过程

        - 如果客户端想要操作服务器，必须通过某种手段，让服务器端发生“状态转化”
        - HTTP协议中四个表示操作方式的动词

            ·GET 查
            ·POST 增
            ·PUT 改
            ·DELETE 删

        概括：
            用URL定位资源，用HTTP动词描述操作

| 操作      | 经典             | Restful           |
|-----------|------------------|-------------------|
| 查询1号图书 | /getBook?id=1    | /book/1 GET方法   |
| 删除1号图书 | /deleteBook?id=1 | /book/1 DELETE方法 |
| 更新1号图书 | /updateBook?id=1 | /book/1 PUT方法   |
| 添加图书   | addBook          | /book POST方法    |

    问题：
        从页面上只能发出GET/POST请求，其他请求如何发出？

### 第六节 搭建REST风格的增删改查系统

    Spring提供了对Rest风格的支持

        - SpringMVC中有一个Filter，可以把普通的请求转换为规定的请求方式

        <filter>
            <filter-name>hiddenHttpMethodFilter</filter-name>
            <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
        </filter>
        <filter-mapping>
            <filter-name>hiddenHttpMethodFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>

        - 在页面中创建一个POST类型的表单，表单中携带一个_method的参数，该参数即被识别为方法

        <form action="book/1" method="post">
            <input class="btn btn-default" type="submit" value="删除图书"/>
            <input type="hidden" name="_method" value="DELETE"/>
        </form>

        ※HTTP状态 405 - 方法不允许
            ·JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS
            ·请求行中接收的方法由源服务器知道，但目标资源不支持

            高版本的Tomcat会阻止JSP响应非标准的请求，故而引起了转发失败

            → 为jsp的page标签添加isError="true"即可让页面继续显示 

### 第七节 SpringMVC获取请求参数

    三个注解：
        @RequestParam
        @RequestHeader
        @CookieValue

    7.1 @RequestParam - 获取请求参数

        1． 直接写一个和参数名请求相同的变量，即可获得访问参数

            - 参数有的时候传入
            - 参数没有的时候null

        2. 用RequestParameter指定参数名

            @RequestParam("username")

            - 参数有的时候传入
            - 参数没有的时候默认报错
                - value
                - required
                - defaultValue

            ※注意区分PathVariable

    7.2 @RequestHeader

        1. 用RequestHeader指定请求头名

            @RequestHeader("User-Agent")

            - 参数有的时候传入
            - 参数没有的时候默认报错
            - 和RequestParam同样有三个参数

    7.3 @CookieValue

        经典写法：
            Cookie[] cookies = request.getCookies(); 
            for (Cookie cookie : cookies) {
                if ("wantedParam".equals(cookie.getName())) {
                    String wantedValue = cookie.getValue(); 
                }
            }

        1. 用CookieValue指定Cookie键值

            @CookieValue("JSESSIONID")

            - 参数有的时候传入
            - 参数没有的时候默认报错
            - 和RequestParam同样有三个参数

    7.4 自动封装对象

        @RequestMapping(value = "/book", method = RequestMethod.POST)
        public String addBook(Book book) {
            System.out.println("添加了新的图书:" + book);
            return "success";
        }

        - 如果参数是一个POJO，则SpringMVC会试图为其每一个属性自动赋值
        - 而且支持级联封装

            name="属性.属性"

    7.5 SpringMVC也提供了原生Web的API

        - 直接写在参数列表里就可以了

        public String handle05(HttpSession httpSession, HttpServletRequest request)

        - 可以传入的对象有：

            ·HttpServletRequest
            ·HttpServletResponse
            ·HttpSession
            ·java.security.Principal
            ·Locale
            ·InputStream

                - ServletInputStream inputStream = request.getInputStream()

            ·OutputStream

                - ServletOutputStream outputStream = response.getOutputStream()

            ·Reader

                - BufferedReader reader = request.getReader();

            ·Writer

                - PrintWriter writer = response.getWriter();

    7.6 解决乱码

        1. 提交的数据有乱码 - 请求乱码

            - GET请求

                改server.xml

                <Connector  URIEncoding="UTF-8" port="8080" ....>

            - POST请求

                在第一次获取请求参数前
                    request.setCharacterEncoding("UTF-8");

        2. 响应的数据有乱码 - 响应乱码

            response.setContentType("text/html;charset=utf-8");

        3. SpringMVC提供了编码Filter

            <filter>
                <filter-name>characterEncodingFilter</filter-name>
                <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
                <init-param>
                    <param-name>encoding</param-name> - 解决POST请求乱码
                    <param-value>UTF-8</param-value>
                </init-param>
                <init-param>
                    <param-name>forceEncoding</param-name> - 顺便解决响应乱码
                    <param-value>true</param-value>
                </init-param>
            </filter>
            <filter-mapping>
                <filter-name>characterEncodingFilter</filter-name>
                <url-pattern>/*</url-pattern>
            </filter-mapping>
    
        ※Filter的配置顺序会影响其作用，EncodingFilter一般都配置在最前

    心得：
        Tomcat装好之后立刻修改Connector处的URIEncoding属性
        配完前端控制器立刻配置CharacterEncodingFilter
