package org.zzq.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.zzq.aware.BeanNameAware;
import org.zzq.bean.Dog;

public class BeanAwareTest {
    /**
     * ===applicationContext===
     * ====ApplicationContextAware====org.springframework.context.support.ClassPathXmlApplicationContext@312b1dae, started on Wed Jan 17 15:52:04 CST 2024
     * ====ApplicationEventPublisherAware====org.springframework.context.support.ClassPathXmlApplicationContext@312b1dae, started on Wed Jan 17 15:52:04 CST 2024
     * ====BeanClassLoaderAware===sun.misc.Launcher$AppClassLoader@18b4aac2
     * ====BeanFactoryAware===org.springframework.beans.factory.support.DefaultListableBeanFactory@4973813a: defining beans [dog,cat,zoo,beanFactoryAwareTest,applicationContextAware,applicationEventPublisherAware,beanClassLoaderAware,beanFactoryAware,beanNameAware,messageSourceAware,resourceLoaderAware,org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventListenerFactory]; root of factory hierarchy
     * ====BeanNameAware===beanNameAware
     * ====MessageSourceAware====org.springframework.context.support.ClassPathXmlApplicationContext@312b1dae, started on Wed Jan 17 15:52:04 CST 2024
     * ====ResourceLoaderAware====org.springframework.context.support.ClassPathXmlApplicationContext@312b1dae, started on Wed Jan 17 15:52:04 CST 2024
     *
     *
     * ===beanFactory===
     * ====BeanNameAware===beanNameAware
     * org.zzq.aware.BeanNameAware@4d339552
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("===applicationContext===");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(("bean.xml"));
        Dog dog = applicationContext.getBean(Dog.class);
        System.out.println(dog.getFoodName());

        System.out.println("===beanFactory===");
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
        //BeanFactory 延迟实例化
        System.out.println(beanFactory.getBean(BeanNameAware.class));
    }
}
