package cn.enjoy.spring.cap3.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest3 {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Cap3MainConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            System.out.println(bean);
        }

        Object bean1 = ac.getBean("person");
        Object bean2 = ac.getBean("person");
        System.out.println(bean1 == bean2);
    }

}
