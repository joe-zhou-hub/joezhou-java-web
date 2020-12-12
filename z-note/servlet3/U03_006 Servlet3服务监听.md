# 1. ServletContextListener

**概念：** 负责监听服务初始化和销毁。
- **初始化：** 服务器启动的时候，触发监听的 `contextInitialized()` 方法。
- **销毁：** 服务器关闭的时候，触发监听的 `contextDestroyed()` 方法。

**源码：** MyApplicationListener.java
```java
/**
 * @author JoeZhou
 */
@WebListener
public class MyApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext application = event.getServletContext();
        System.out.print("一个应用出生了，通过它获取到项目名...");
        System.out.println(application.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        ServletContext application = event.getServletContext();
        System.out.print("一个应用销毁了，通过它获取到项目名...");
        System.out.println(application.getContextPath());
    }
}
```

# 2. ServletContextAttributeListener

**概念：** 负责监听服务域中属性的添加、删除或者替换操作。

**源码：** MyApplicationAttributeListener.java
```java
/**
 * @author JoeZhou
 */
@WebListener
public class MyApplicationAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        // 添加的key和value
        System.out.print("服务域中添加了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }
    
    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        // 获取的是替换的新Key，和原来的旧value
        System.out.print("服务域中替换了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }
    
    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        // 删除的key和value
        System.out.print("服务域中删除了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }
}
```

**源码：** ApplicationAttributeListenerServlet.java
```java
/**
 * @author JoeZhou
 */
@WebServlet("/servlet/applicationAttributeListener")
public class ApplicationAttributeListenerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String meta = req.getParameter("meta");
        String create = "create";
        String replace = "replace";
        String remove = "remove";
        if (create.equals(meta)) {
            ServletContext application = req.getServletContext();
            application.setAttribute("applicationKey", "applicationValue");
        }
        if (replace.equals(meta)) {
            ServletContext application = req.getServletContext();
            application.setAttribute("applicationKey", "applicationValue2");
        }
        if (remove.equals(meta)) {
            ServletContext application = req.getServletContext();
            application.removeAttribute("applicationKey");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.doGet(req, resp);
    }
}
```


