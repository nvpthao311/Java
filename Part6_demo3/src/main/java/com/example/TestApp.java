package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfiguration.class);

        ClientService client= (ClientService) applicationContext.getBean(ClientService.class);
        client.processMsg("Da nhan duoc");

    }
}
