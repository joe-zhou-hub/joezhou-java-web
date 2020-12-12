# 1. 报表打印

**概念：** 我们可以利用 `Servlet` 来将数据对应打印在一个Excel表格文件中。

**流程：** 
1. **引入依赖：** 因为我们要使用是一个转换器，这个转换器是第三方jar包中的 `XLSTransformer` 类。
2. **准备模板：** 准备一个Excel模板，Excel模板中使用EL表达式和  `<jx>` 标签来取值。
3. **准备数据：** 数据的类型是Map类型，Map里面我们存放数据和标题，或者其他内容。
4. **创建Servlet：** 创建 `ExcelServlet.java`。
5. 使用`transformer.transformXLS()`，进行Map数据和Excel文件的一个转换。
    - p1：文件的模板，得告诉转换器按照怎样的一个格式来转换
    - p2：数据，得告诉转换器，你要转什么内容
    - p3：输出路径，得告诉转换器将文件转换成功后放在哪里（必须带文件名）
（可选）如果想下载下来，可以直接重定向这个文件的位置。

**链接：** [studentTemplate.xls](http://note.youdao.com/noteshare?id=06b2ef6b6653389185faee47c2107f03&sub=03DDCE1673464C849E6EA6729C089D3D)

# 2. 引入依赖

**配置：** pom.xml
```xml 
<dependency>
    <groupId>net.sf.jxls</groupId>
    <artifactId>jxls-core</artifactId>
    <version>1.0-RC-2</version>
</dependency>
```

# 3. 准备Excel模版

**概念：** 在 `/view/template` 下新建一个template.xls模板

![](https://user-gold-cdn.xitu.io/2020/4/28/171bfbbf67f7eb18?w=910&h=320&f=png&s=12474)

# 4. 准备数据

**概念：** 准备一套 `List<Map>` 结构的数据，当然，也可以使用 `List<Pojo>` 结构的数据，但无论准备的是什么格式的数据，最终都要放到一个 `Map` 中。

**源码：**
```java
/**
 * @author JoeZhou
 */
public class ExcelDataTool {

    public static Map<String, Object> getStudents() {
        // 标题
        String title = "学生成绩单";

        // 报表内容
        List<Map<String, Object>> students = new ArrayList<>();

        // 结果数据：最终返回的数据
        Map<String, Object> resultData = new HashMap<>(10);


        // 学生数量
        int studentsLength = 100;

        // 循环注入100个学生
        for (int i = 1; i <= studentsLength; i++) {
            Map<String, Object> map = new HashMap<>(3);
            map.put("id", "00" + i);
            map.put("name", "赵四" + i);
            map.put("score", i + 1);
            students.add(map);
        }

        // 将内容和标题都放到结果数据中
        resultData.put("title", title);
        resultData.put("students", students);

        return resultData;
    }
}
```

# 5. 准备Servlet

**概念：** 文件输出位置文件夹也可以手动在 `tomcat/webapps/` 项目的发布路径下创建。

**源码：** ExcelServlet.java
```java
/**
 * @author JoeZhou
 */
@WebServlet("/servlet/excel")
public class ExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // excel模版路径：告诉我你的excel模板在哪里
        String path = "/view/template/studentTemplate.xls";
        String templatePath = req.getServletContext().getRealPath(path);

        // excel文件输出位置文件夹：告诉我你生成的excel文件放到哪里
        String excelDirPath = req.getServletContext().getRealPath("/excel");

        File file = new File(excelDirPath);

        // 如果excel文件夹不存在，则创建一个。
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            System.out.println(mkdirs);
        }

        // 创建一个xls转换器，用于将数据转换成xls语言
        XLSTransformer transformer = new XLSTransformer();

        // 将数据转换成excel格式，需要抛异常
        // 参数1：模版文件路径
        // 参数2：待转换数据
        // 参数3：转换后文件路径：需要自己设置文件名，后缀必须是xls，可以使用中文。
        // 理解：将[参数2]按照[参数1]的格式转成[参数3]
        try {
            transformer.transformXLS(templatePath, ExcelDataTool.getDataMap(), excelDirPath + "/students.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 直接重定向访问要打印的文件可以下载文件，但这种方式无法识别中文，如果是中文，使用IO流下载
        resp.sendRedirect(req.getContextPath() + "/excel/students.xls");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}
```

