package com.example.springwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class BaseConfig {
    @Bean
    public CorsFilter getCorsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");//允许的域名
        configuration.addAllowedMethod("*");//允许的请求方式
        configuration.addAllowedHeader("*");//允许的请求头
        source.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(source);
    }
}
