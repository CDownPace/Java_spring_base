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



### 一个创建Bean对象的工厂
> Bean：在计算机英语中，有可重用组件的含义。
> JavaBean：用java语言编写的可重用组件。
> javabean >  实体类
 
##### 它就是创建我们的service和dao对象的。

* 第一个：需要一个配置文件来配置我们的service和dao
           配置的内容：唯一标识=全限定类名（key=value)
* 第二个：通过读取配置文件中配置的内容，反射创建对象
   *我的配置文件可以是xml也可以是properties
 
 
 ### 单例对象和多例对象
 ![avatar](http://note.youdao.com/yws/public/resource/17e41f0bc81c321444f3c7f93de83a99/xmlnote/2F6F5D10134945F4BA939CB49362C344/6520)


### 使用spring创建bean
打开源码，点击core,搜索xmlns，copy到bean.xml

### 获取spring的Ioc核心容器，并根据id获取对象
    * ApplicationContext的三个常用实现类：
> ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
> FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
> AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容。
##### 核心容器的两个接口引发出的问题：
* ApplicationContext:     单例对象适用              采用此接口
   * 它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
* BeanFactory:            多例对象使用
   * 它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。

