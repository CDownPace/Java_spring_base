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

### spring中的依赖注入
> 依赖注入：
* Dependency Injection
> IOC的作用：
* 降低程序间的耦合（依赖关系）
> 依赖关系的管理：
* 以后都交给spring来维护

        在当前类需要用到其他类的对象，由spring为我们提供，我们只需要在配置文件中说明
> 依赖关系的维护：

就称之为依赖注入。
> 依赖注入：
    
    能注入的数据：有三类
          * 基本类型和String
          * 其他bean类型（在配置文件中或者注解配置过的bean）
          * 复杂类型/集合类型
     
     注入的方式：有三种
          * 第一种：使用构造函数提供
          * 第二种：使用set方法提供
          * 第三种：使用注解提供（明天的内容）
          
```java
 <!-- set方法注入                更常用的方式
        涉及的标签：property
        出现的位置：bean标签的内部
        标签的属性
            name：用于指定注入时所调用的set方法名称
            value：用于提供基本类型和String类型的数据
            ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象
        优势：
            创建对象时没有明确的限制，可以直接使用默认构造函数
        弊端：
            如果有某个成员必须有值，则获取对象是有可能set方法没有执行。
    -->

```

```java
 <!-- 
    复杂类型的注入/集合类型的注入
        用于给List结构集合注入的标签：
            list array set
        用于个Map结构集合注入的标签:
            map  props
        结构相同，标签可以互换
    -->
```
---
### 第二天大体内容
> spring 基于注解的IOC的案例
* spring中ioc的注解
* 案例使用xml方式和注解方式实现单表的CRUD操作
         
         持久层技术选择：dbutils
* 改造基于注解的ioc案例，使用纯注解的方式实现

         spring的一些新注解使用
* spring和Junit整合




#### 曾经XML的配置：
 ```java
 <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
        scope=""  init-method="" destroy-method="">
     <property name=""  value="" | ref=""></property>
 </bean>
```
 * 用于创建对象的
     * 他们的作用就和在XML配置文件中编写一个<bean>标签实现的功能是一样的
     * Component:
     * Component(value="accountService")
     * 作用：用于把当前类对象存入spring容器中
     * 属性：
     * value：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写。
     * Controller：一般用在表现层
     * Service：一般用在业务层
     * Repository：一般用在持久层
     * 以上三个注解他们的作用和属性与Component是一模一样。
     * 他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰

 * 用于注入数据的
     * 他们的作用就和在xml配置文件中的bean标签中写一个<property>标签的作用是一样的
     * Autowired:
     * 作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
     * 如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
     * 如果Ioc容器中有多个类型匹配时：
     * 出现位置：
     * 可以是变量上，也可以是方法上
     * 细节：
     * 在使用注解注入时，set方法就不是必须的了。
     * Qualifier:
     * 作用：在按照类中注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注入时可以（稍后我们讲）
     * 属性：
     * value：用于指定注入bean的id。
     * 必须和autowired一起使用
     * Resource
     * 作用：直接按照bean的id注入。它可以独立使用
     *  属性：
     * name：用于指定bean的id。
     * 以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
     * 另外，集合类型的注入只能通过XML来实现。
 
     * Value
     * 作用：用于注入基本类型和String类型的数据
     * 属性：
     * value：用于指定数据的值。它可以使用spring中SpEL(也就是spring的el表达式）
     * SpEL的写法：${表达式}
 
 * 用于改变作用范围的
     * 他们的作用就和在bean标签中使用scope属性实现的功能是一样的
     * Scope
     * 作用：用于指定bean的作用范围
     * 属性：
     * value：指定范围的取值。常用取值：singleton prototype
 
 * 和生命周期相关 了解
     * 他们的作用就和在bean标签中使用init-method和destroy-methode的作用是一样的
     * PreDestroy
     * 作用：用于指定销毁方法
     * PostConstruct
     * 作用：用于指定初始化方法


 ![avatar](https://www.z4a.net/image/TaTFeU)

---
### 第三天大体内容
> 完善我们的account案例
> 分析案例中的问题
> 回顾之前讲的一个技术：动态代理
> 动态代理的另一种实现方式
> 解决案例中的问题
> AOP的概念
> spring中的AOP相关术语
> spring中基于XML和注解的AOP配置
此处过后请放置第三张图片
