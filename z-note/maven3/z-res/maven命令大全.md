# 1. maven常见命令

maven 命令的格式为 mvn [plugin-name]:[goal-name]，可以接受的参数如下。

符号 | 描述
---|---
-D | 指定参数，如 -Dmaven.test.skip=true 跳过单元测试；
-P | 指定 Profile 配置，可以用于区分环境；
-e | 显示maven运行出错的信息；
-o | 离线执行命令,即不去远程仓库更新包；
-X | 显示maven允许的debug信息；
-U | 强制去远程更新snapshot的插件或依赖，默认每天只更新一次。

命令 | 描述
---|---
mvn archetype:create | 创建maven项目
-DgroupId=packageName | 指定groupId
-DartifactId=projectName | 指定artifactId
-DarchetypeArtifactId=maven-archetype-webapp | 创建web项目
mvn archetype:generate | 创建maven项目
mvn validate | 验证项目是否正确
mvn package | maven打包
mvn jar:jar | 只打jar包
mvn source:jar | 生成源码jar包
mvn generate-sources | 产生应用需要的任何额外的源代码
mvn compile | 编译源代码
mvn test-compile | 编译测试代码
mvn test | 运行测试
mvn verify | 运行检查
mvn clean | 清理maven项目
mvn eclipse:eclipse | 生成eclipse项目
mvn eclipse:clean | 清理eclipse配置
mvn idea:idea | 生成idea项目
mvn install | 安装项目到本地仓库：
mvn:deploy | 发布项目到远程仓库：
mvn integration-test | 在集成测试可以运行的环境中处理和发布包
mvn dependency:tree | 显示maven依赖树
mvn dependency:list | 显示maven依赖列表
mvn dependency:sources | 下载依赖包的源码

# 2. web项目相关命令

命令 | 描述
---|---
mvn tomcat:run | 启动tomcat
mvn jetty:run | 启动jetty
mvn tomcat:deploy | 运行打包部署
mvn tomcat:undeploy | 撤销部署
mvn tomcat:start | 启动web应用
mvn tomcat:stop | 停止web应用
mvn tomcat:redeploy | 重新部署
mvn war:exploded tomcat:exploded    | 部署展开的war文件：


 