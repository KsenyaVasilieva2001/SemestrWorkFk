package ru.kpfu.itis.skatingblog.config;


import freemarker.ext.jsp.TaglibFactory;
import freemarker.template.TemplateException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import ru.kpfu.itis.skatingblog.converters.DateConverter;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Date;

@Configuration
@EnableAspectJAutoProxy
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public DateConverter dateConverter(){
        return new DateConverter();
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
/*
       registry.addResourceHandler(
                        "/images/**",
                        "/css/**")
                .addResourceLocations(
                        "classpath:/static/images/",
                        "classpath:/static/css/");


*/


        registry.addResourceHandler("/static/**").addResourceLocations("classpath:static/");
    }

}


