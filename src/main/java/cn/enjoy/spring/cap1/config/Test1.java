package cn.enjoy.spring.cap1.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig1.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String bean:
                beanDefinitionNames) {
            System.out.println(bean);

        }
    }

}
