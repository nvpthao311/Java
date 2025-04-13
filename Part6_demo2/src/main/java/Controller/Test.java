package Controller;

import model.Teacher;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        AbstractApplicationContext context;
        context = new ClassPathXmlApplicationContext("Beans.xml");
        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(teacher.toString());
    }
}
