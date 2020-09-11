# spring 
> spring 框架的概述以及spring中基于xml的ioc配置

> spring 中基于注解的ioc和ioc案例

> spring中的aop 和基于xml以及注解的aop配置

> spring中的jdbcTemlate以及spring事务控制

* spring的概念
* 程序的耦合和解耦
  * 曾经案例中的问题
  * 工厂模式解耦
* ioc概念和spring中的ioc 
  spring中基于xml的ioc环境搭建
   * 依赖注入
   
 ### spring的优势
 * 方便解耦，简易开发
 * aop编程的支持
 * 声明式事务的支持
 * 方便程序的测试
 * 方便集成各种优秀框架
 * 降低javaEE API的使用难度
 * java源码事经典学习范例
   
 ### Spring体系结构
![avatar](https://note.youdao.com/yws/public/resource/17e41f0bc81c321444f3c7f93de83a99/xmlnote/D31FC1764B1C41D999AEE6320A75E0A8/6518)

### 解决耦合的办法
程序的耦合
耦合：程序间的依赖关系
包括：
* 类之间的依赖
* 方法间的依赖

解耦：
 * 降低程序间的依赖关系
 
实际开发中：

应该做到：编译期不依赖，运行时才依赖。

解耦的思路：
* 第一步：使用反射来创建对象，而避免使用new关键字。
* 第二步：通过读取配置文件来获取要创建的对象全限定类名
