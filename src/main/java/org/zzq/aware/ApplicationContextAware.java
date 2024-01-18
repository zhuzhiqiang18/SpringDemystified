package org.zzq.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextAware implements org.springframework.context.ApplicationContextAware  {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("====ApplicationContextAware===="+applicationContext);

    }
}
