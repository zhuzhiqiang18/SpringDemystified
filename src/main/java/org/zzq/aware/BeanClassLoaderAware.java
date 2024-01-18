package org.zzq.aware;

import org.springframework.stereotype.Component;

@Component
public class BeanClassLoaderAware implements org.springframework.beans.factory.BeanClassLoaderAware {

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("====BeanClassLoaderAware==="+classLoader);
    }
}
