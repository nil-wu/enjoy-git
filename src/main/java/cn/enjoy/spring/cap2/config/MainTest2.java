package cn.enjoy.spring.cap2.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest2 {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beean : beanDefinitionNames) {
            System.out.println(beean);
        }
    }

}
