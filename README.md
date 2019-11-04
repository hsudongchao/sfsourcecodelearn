# sfsourcecodelearn
《Spring源码深度解析》笔记及代码
## 各个包描述
1. `test.bean.*`：bean的加载测试
2. `test.lookup.*`：lookup-method测试demo
3. `test.replaced.*`：replaced-method测试demo
4. `test.customtag.*`：自定义标签解析测试demo

## 用到的设计模式
1. 工厂模式

2. 委托模式
    
    > `XmlBeanDefinitionReader#detectValidationMode`方法中，将检测xml模式的工作委托给了`XmlValidationModeDetector`
    
3. 模板方法模式
    > `DefaultBeanDefinitionDocumentReader#doRegisterBeanDefinitions`方法中，`preProcessXml`和`postProcessXml`两个空方法
 
4. 单例模式
5. 原型模式


## 摘抄
### 第一部分 核心实现
1. 就像*面向对象设计方法学*中常说的一句话，一个类要么是*面向继承*设计的，要么就用`final`修饰。
2. 子元素`lookup-method`似乎并不是很常用，但是在默写时候它的确是非常有用的属性，通常我称它为**获取器注入**。引用*Spring in Action*中一句话，**获取器注入**是一种特殊的方法注入，它是把一个方法声明为返回莫衷类型的`bean`，但实际要返回的bean是在配置文件里面配置的，此方法可用在设计有些可插拔的功能时，解除程序依赖。
3. 方法替换（`replaced-method`）：可以在运行时用新的方法替换现有的方法。与`look-up`不同的是，`replaced-method`不但可以动态地替换返回实体bean，而且还能动态的更改原有方法的逻辑。
4. `synchronized`同步代码块，要做两次判断，参看方法`DefaultNamespaceHandlerResolver#getHandlerMappings`
5. 循环依赖（循环引用），区别于循环调用（无法解决，除非有终结条件，否则就是死循环，最终导致内存溢出错误）。循环依赖包含：
   
   a. 构造器循环依赖。通过构造器注入方式构成的循环依赖，无法解决，只能抛出`BeanCurrentlyInCreationException`异常表示循环依赖。
   
   b. `setter`循环依赖。通过`setter`注入方式构成的循环依赖。对于通过`setter`注入方式造成的循环依赖是通过`Spring`容器提前暴露刚完成构造器注入但未完成其他步骤（如`setter`注入）的bean来解决的，而且只能解决单例作用域的`bean`循环依赖。
   
   c. `prototype`范围的依赖处理。对于`prototype`作用域的`bean`，`Spring`容器无法完成依赖注入，因为`Spring`容器不会缓存`prototype`作用域的`bean`，因此无法提前暴露一个创建中的`bean`。
6. `Spring`中提供一些`Aware`相关的接口，比如`BeanFactoryAware`、`ApplicationContextAware`、`ResourceLoaderAware`、`ServletContextAware`等，实现这些`Aware`接口的`Bean`在初始化之后，可以取得一些相对应的资源，例如实现`BeanFactoryAware`的`bean`在初始化后，`Spring`容器将会注入`BeanFactory`的实例，而实现`ApplicationContextAware`在被初始化后，将会被注入`ApplicationContext`的实例。

### 第二部分 企业应用
### 第三部分 Spring Boot