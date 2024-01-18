package org.zzq.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryAware implements org.springframework.beans.factory.BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("====BeanFactoryAware==="+beanFactory);
    }
}
