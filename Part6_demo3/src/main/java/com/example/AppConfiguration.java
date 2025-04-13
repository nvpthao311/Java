package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//đánh dấu trên một class, cho biết rằng class đó chứa các thông tin cấu hình cho ứng dụng
// quét hết tất cả các bean trong class
@ComponentScan("com.example")
//tự động tìm kiếm và quản lý các bean-@component trong ứng dụng của bạn
public class AppConfiguration {

}
