package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//đánh dấu trên các Class để giúp Spring biết nó là một Bean
public class ClientService {
    private EmailService emailService;

    @Autowired
    //đánh dấu cho Spring biết rằng sẽ tự động inject bean tương ứng vào vị trí được đánh dấu
    public ClientService (EmailService emailService){
        this.emailService = emailService;
    }

    public void processMsg(String message){
        emailService.sendMsg(message);
    }
}
