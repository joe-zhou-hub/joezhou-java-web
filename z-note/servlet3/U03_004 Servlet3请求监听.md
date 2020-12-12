# 1. ServletRequestListener

**概念：** 负责监听请求的初始化和销毁操作。

**源码：** MyRequestListener.java
```java
/**
 * @author JoeZhou
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        ServletRequest request = event.getServletRequest();
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.print("一个请求出生了...");
        System.out.println("URL是: " + req.getRequestURI());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        ServletRequest request = event.getServletRequest();
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.print("一个请求销毁了...");
        System.out.println("URL是: " + req.getRequestURI());
    }
}
```

# 2. ServletRequestAttributeListener

**概念：** 负责监听请求域中属性的添加、删除或者替换操作。

**源码：** MyRequestAttributeListener.java
```java
/**
 * @author JoeZhou
 */
@WebListener
public class MyRequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        // 被添加的key和value
        System.out.print("请求域中添加了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        // 被替换的key和原来的value
        System.out.print("请求域中替换了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        // 被删除的key和value
        System.out.print("请求域中删除了属性...");
        System.out.println(event.getName() + ":" + event.getValue());
    }
}
```

**源码：** RequestAttributeListenerServlet.java
```java
/**
 * @author JoeZhou
 */
@WebServlet("/servlet/requestAttributeListener")
public class RequestAttributeListenerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String meta = req.getParameter("meta");
        String add = "add";
        String replace = "replace";
        String remove = "remove";
        if (add.equals(meta)) {
            req.setAttribute("requestKey", "requestValue");
        }
        if (replace.equals(meta)) {
            req.setAttribute("requestKey", "requestValue");
            req.setAttribute("requestKey", "requestValue2");
        }
        if (remove.equals(meta)) {
            req.setAttribute("requestKey", "requestValue");
            req.removeAttribute("requestKey");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        this.doGet(req, resp);
    }
}
```
