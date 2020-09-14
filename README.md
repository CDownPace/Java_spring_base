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


### 负载均衡
![avatar](http://note.youdao.com/yws/public/resource/17e41f0bc81c321444f3c7f93de83a99/xmlnote/6B72AC9A86A34311971EEB2078A9A3DD/6523)


```
<!--把对象的创建交给spring来管理-->
    <!--spring对bean的管理细节
        1.创建bean的三种方式
        2.bean对象的作用范围
        3.bean对象的生命周期
    -->

    <!--创建Bean的三种方式 -->
    <!-- 第一种方式：使用默认构造函数创建。
            在spring的配置文件中使用bean标签，配以id和class属性之后，且没有其他属性和标签时。
            采用的就是默认构造函数创建bean对象，此时如果类中没有默认构造函数，则对象无法创建。

    <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"></bean>
    -->

    <!-- 第二种方式： 使用普通工厂中的方法创建对象（使用某个类中的方法创建对象，并存入spring容器  想使用配置文件中类的属性）
    <bean id="instanceFactory" class="com.itheima.factory.InstanceFactory"></bean>
    <bean id="accountService" factory-bean="instanceFactory" factory-method="getAccountService"></bean>
    -->

    <!-- 第三种方式：使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入spring容器)
    <bean id="accountService" class="com.itheima.factory.StaticFactory" factory-method="getAccountService"></bean>
    -->

    <!-- bean的作用范围调整
        bean标签的scope属性：
            作用：用于指定bean的作用范围
            取值： 常用的就是单例的和多例的
                singleton：单例的（默认值）
                prototype：多例的
                request：作用于web应用的请求范围
                session：作用于web应用的会话范围
                global-session：作用于集群环境的会话范围（全局会话范围），当不是集群环境时，它就是session

    <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl" scope="prototype"></bean>
    -->

    <!-- bean对象的生命周期
            单例对象
                出生：当容器创建时对象出生
                活着：只要容器还在，对象一直活着
                死亡：容器销毁，对象消亡
                总结：单例对象的生命周期和容器相同
            多例对象
                出生：当我们使用对象时spring框架为我们创建
                活着：对象只要是在使用过程中就一直活着。
                死亡：当对象长时间不用，且没有别的对象引用时，由Java的垃圾回收器回收
     -->
```
