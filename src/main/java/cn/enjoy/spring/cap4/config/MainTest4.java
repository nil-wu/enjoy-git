package cn.enjoy.spring.cap4.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest4 {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Cap4MainConfig.class);
        System.out.println("IOC容器创建完成");
        ac.getBean("person");
    }

}
