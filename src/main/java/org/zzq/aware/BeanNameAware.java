package org.zzq.aware;

import org.springframework.stereotype.Component;

@Component
public class BeanNameAware implements org.springframework.beans.factory.BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("====BeanNameAware==="+name);
    }
}
