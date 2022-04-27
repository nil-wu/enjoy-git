package cn.enjoy.spring.cap6.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest6 {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Cap6MainConfig.class);
        ApplicationContext ac2 = new ClassPathXmlApplicationContext("");

//        Object bean = ac.getBean("&cn.enjoy.spring.bean.JamesFactoryBean");
//        Object bean = ac.getBean("jamesImportSelect");

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

    }
}
