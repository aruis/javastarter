package com.aruistar.javastarter.core.config

import com.aruistar.javastarter.core.interceptor.LoginInterceptor
import com.aruistar.javastarter.core.interceptor.SkipLoginInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MvcConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor
    @Autowired
    SkipLoginInterceptor skipLoginInterceptor

    @Override
    void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login.html", "/login")
        registry.addInterceptor(skipLoginInterceptor).addPathPatterns("/login.html")
    }

}
