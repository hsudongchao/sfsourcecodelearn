# sfsourcecodelearn
《Spring源码深度解析》笔记及代码

## 用到的设计模式
1. 工厂模式

2. 委托模式
    
    > `XmlBeanDefinitionReader#detectValidationMode`方法中，将检测xml模式的工作委托给了`XmlValidationModeDetector`
    
3. 模板方法模式
    > `DefaultBeanDefinitionDocumentReader#doRegisterBeanDefinitions`方法中，`preProcessXml`和`postProcessXml`两个空方法
    


## 摘抄
1. 就像*面向对象设计方法学*中常说的一句话，一个类要么是*面向继承*设计的，要么就用`final`修饰。
2. 子元素`lookup-method`似乎并不是很常用，但是在默写时候它的确是非常有用的属性，通常我称它为**获取器注入**。引用*Spring in Action*中一句话，**获取器注入**是一种特殊的方法注入，它是把一个方法声明为返回莫衷类型的bean，但实际要返回的bean是在配置文件里面配置的，此方法可用在设计有些可插拔的功能时，解除程序依赖。
3. 方法替换（`replaced-method`）：可以在运行时用新的方法替换现有的方法。与`look-up`不同的是，`replaced-method`不但可以动态地替换返回实体bean，而且还能动态的更改原有方法的逻辑。