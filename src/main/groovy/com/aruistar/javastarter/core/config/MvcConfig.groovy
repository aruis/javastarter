package com.aruistar.javastarter.core.config

import com.aruistar.javastarter.core.interceptor.LoginInterceptor
import com.aruistar.javastarter.core.interceptor.SkipLoginInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@ConfigurationProperties(prefix = "app.auth")
class MvcConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor
    @Autowired
    SkipLoginInterceptor skipLoginInterceptor

    String login
    List<String> whitelist

    @Override
    void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(login, *whitelist)
        registry.addInterceptor(skipLoginInterceptor).addPathPatterns(login)
    }

}
