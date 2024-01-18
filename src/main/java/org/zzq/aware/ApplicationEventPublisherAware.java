package org.zzq.aware;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventPublisherAware implements org.springframework.context.ApplicationEventPublisherAware  {
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("====ApplicationEventPublisherAware===="+applicationEventPublisher);
    }
}
