package com.example.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@ComponentScan("com.*")
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    //配置Swagger
    @Configuration
    static class WebMvcConfigurer extends App {
        WebMvcConfigurer() {
            
        }
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new HandlerInterceptorAdapter() {
                public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + request.getServletPath();
                    if(url.contains("/error")) {
                        response.sendRedirect("/swagger-ui.html");
                    }
                    return true;
                }
            }).addPathPatterns("/**");
        }
    }

}
