package cn.enjoy.spring.cap7.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest7 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Cap7Config.class);
        System.out.println("容器初始化完成");
//        ac.getBean("bike");
        ac.close();
    }

}
