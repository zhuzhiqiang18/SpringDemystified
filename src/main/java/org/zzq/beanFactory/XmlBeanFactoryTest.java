package org.zzq.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.zzq.bean.Zoo;

/**
 * 配置文件如何把定义的bean转换为BeanDefinition 主要实现类是BeanDefinitionReader
 * BeanDefinitionRegistry beanRegistry = <某个BeanDefinitionRegistry实现类，通常为DefaultListableBeanFactory>;
 * BeanDefinitionReader beanDefinitionReader = new BeanDefinitionReaderImpl(beanRegistry);
 * beanDefinitionReader.loadBeanDefinitions("配置文件路径");
 */
public class XmlBeanFactoryTest {
    public static void main(String[] args) {
        applicationContext();
        xmlBeanFactory();
        xmlBeanDefinitionReader();
    }



    public static void applicationContext(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Zoo zoo = (Zoo) applicationContext.getBean("zoo");
        zoo.play();
    }

    /**
     * Spring框架中的 `XmlBeanFactory` 类已被标记为废弃，主要是因为 `ApplicationContext` 提供了更多的高级特性，并且几乎可以替代 `BeanFactory` 的所有功能。
     *
     * `XmlBeanFactory` 仅在调用 `getBean(String name)` 方法时才创建对象。而 `ApplicationContext` 在启动时会创建所有的单例Bean。这种预先创建Bean的行为，可以发现可能存在的问题并及早解决，比如在启动的早期阶段就能够发现配置错误。
     *
     * 除此之外，`ApplicationContext` 还提供了许多 `BeanFactory` 不提供的其他功能。例如，它可以自动识别并使用MessageSource实现，从而提供国际化（i18n）功能。它还提供了各种应用事件的发布功能，以及多种不同的应用层次（如web应用中的WebApplicationContext）。
     *
     * 因此，对大多数使用Spring的应用，推荐直接使用 `ApplicationContext`。
     */
    public static void xmlBeanFactory(){
        BeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
        Zoo zoo = (Zoo) xmlBeanFactory.getBean("zoo");
        zoo.play();
    }

    private static void xmlBeanDefinitionReader() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        System.out.println(defaultListableBeanFactory);
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions("bean.xml");
        BeanFactory beanFactory = (BeanFactory) beanDefinitionReader.getRegistry();
        System.out.println(beanFactory);
        Zoo zoo = (Zoo) beanFactory.getBean("zoo");
        zoo.play();
    }

}
