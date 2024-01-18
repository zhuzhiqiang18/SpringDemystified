package org.zzq.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.zzq.bean.Cat;
import org.zzq.bean.Dog;
@Component
public class EatPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("==postProcessBeforeInitialization=="+beanName);
        if (bean instanceof Dog){
            Dog dog = (Dog) bean;
            dog.setFoodName("狗粮");
        }
        if (bean instanceof Cat){
            Cat cat = (Cat) bean;
            cat.setFoodName("猫粮");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("==postProcessBeforeInitialization=="+beanName);
        return bean;
    }

}
