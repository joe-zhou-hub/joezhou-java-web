# 2. JSP文件

**概念：** 
- 如果你在Servlet中将值存了起来，目的是为了将来展示在页面上，则页面端无法使用HTML文件，需要使用JSP文件，JSP也是一个Servlet，只不过它工作在页面端，如此说来，你用后端的Servlet去存，用前端的Servlet（JSP）来取，就显得合情合理。
- JSP = HTML + JAVA + JSP自己的标签。

- **页面取值：** `${requestScope["username"]}` 或 `${username}`
- **页面取值：** `${sessionScope["username"]}`
- **页面取值：** `${applicationScope["username"]}`

# 4. IDEA中的EL表达式支持

**概念：** IDEA中的jsp文件不支持EL表达式，因为Servlet2对应jsp1.2，默认使用 `isELIgnored=true`，而Servlet3对应jsp2.0，默认使用 `isELIgnored=false`，在IDEA中，`web.xml` 默认使用Servlet2对应的jsp1.2，导致EL表达式不可用。

## 4.1 解决方案：单个JSP

**概念：** 在jsp的头部添加 `isELIgnored="false"`。

**配置：**
```html
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
```

## 4.2 解决方案：全部JSP

**概念：** 直接在web.xml的<web-app>标签的命名空间内容，提升servlet版本为3.1。

**配置：**
```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

</web-app>
```

- **URL重写方案：** 如果浏览器不支持Cookie，或者禁用了cookie，那么session将无法使用，这时候就需要使用"URL重写"方案。
    - URL重写时，必需要对你的URL进行重新编码，否则不会生效，代码为：`resp.encodeURL("/servlet/TestServlet")`，这个编码的过程会将 `sessionID` 附加到URL的末尾，以保证浏览器和服务器之间能正常的交换 `sessionID`。
    - 当你使用了URL重写方案之后，容器还是会先尝试使用Cookie方案进行 `sessionID` 的交换，如果失败了，才会退而求其次，使用URL重写方案。
    - 只有JSP或者Servlet之类的动态资源才可以使用URL重写，静态资源如HTML等，不能URL重写，而且本身HTML页面也无法使用session。
    - 重定向有一个简单地URL重写方式：`resp.encodeRedirectURL("/servlet/login");`