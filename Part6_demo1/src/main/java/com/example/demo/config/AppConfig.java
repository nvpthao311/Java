package com.example.demo.config;

import com.example.demo.beans.HelloWorld;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class AppConfig {

    @Bean
    public HelloWorld helloWorldBean(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!!! (java)");

        return helloWorld;
    }
}
