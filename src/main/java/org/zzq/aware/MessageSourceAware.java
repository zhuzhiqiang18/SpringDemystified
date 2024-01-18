package org.zzq.aware;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceAware implements org.springframework.context.MessageSourceAware  {
    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("====MessageSourceAware===="+messageSource);

    }
}
