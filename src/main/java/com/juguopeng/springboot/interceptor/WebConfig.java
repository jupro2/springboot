package com.juguopeng.springboot.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 风
 * @Date 2023 05 2023/5/23
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SensitiveWordInterceptor sensitiveWordInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sensitiveWordInterceptor)
                .addPathPatterns("/comment/insert");
    }
}