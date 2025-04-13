package com.example.demo;

import com.example.demo.beans.HelloWorld;
import com.example.demo.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorldBean");

        System.out.println(helloWorld.getMessage());

    }
}
