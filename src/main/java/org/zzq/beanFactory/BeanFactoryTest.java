package org.zzq.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.zzq.bean.Cat;
import org.zzq.bean.Dog;
import org.zzq.bean.Zoo;

public class BeanFactoryTest {
    public static void main(String[] args) {

        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory beanFactory = bindViaCode(beanRegistry);
        Zoo zoo = (Zoo) beanFactory.getBean("zoo");
        zoo.play();
    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry)
    {
        RootBeanDefinition dog = new RootBeanDefinition();
        dog.setBeanClass(Dog.class);

        AbstractBeanDefinition cat = new RootBeanDefinition();
        cat.setBeanClass(Cat.class);

        RootBeanDefinition zoo =  new RootBeanDefinition();
        zoo.setBeanClass(Zoo.class);

        // 将bean定义注册到容器中
        registry.registerBeanDefinition("dog", dog);
        registry.registerBeanDefinition("cat", cat);
        registry.registerBeanDefinition("zoo", zoo);
        // 指定依赖关系
        // 1. 可以通过构造方法注入方式
        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0, dog);
        argValues.addIndexedArgumentValue(1, cat);
        zoo.setConstructorArgumentValues(argValues);
        // 2. 或者通过setter方法注入方式
//        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("dog",dog));
//        propertyValues.addPropertyValue(new PropertyValue("cat",cat));
//        zoo.setPropertyValues(propertyValues);
        // 绑定完成
        return (BeanFactory)registry;
    }
}
