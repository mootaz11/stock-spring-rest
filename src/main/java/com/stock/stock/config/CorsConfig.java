package com.stock.stock.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    @PropertySource(value= "classpath:/application.properties")
    @EnableWebMvc
    public class CorsConfig implements WebMvcConfigurer {
        private String server ;
        private String port ;
        private String frontendName;

        public CorsConfig(Environment env ){
                 server = env.getProperty("frontend.server") ;
                 port = env.getProperty("frontend.port");
                 frontendName = "http://"+server+":"+port;

           }


        @Override
        public void addCorsMappings(CorsRegistry registry)

        {
            System.out.println(frontendName);
            WebMvcConfigurer.super.addCorsMappings(registry);

            registry.addMapping("/**").allowedOrigins(frontendName)
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "PATCH")
                    .allowCredentials(true);

        }

    }

