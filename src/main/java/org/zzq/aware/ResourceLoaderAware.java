package org.zzq.aware;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ResourceLoaderAware implements org.springframework.context.ResourceLoaderAware  {
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("====ResourceLoaderAware===="+resourceLoader);
    }
}
