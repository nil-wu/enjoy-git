package cn.enjoy.spring.cap8.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MainTest8 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Cap8MainConfig.class);

        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        Bird bird = (Bird) ac.getBean("bird");
        System.out.println(bird);

        ConfigurableEnvironment environment = ac.getEnvironment();
        String property = environment.getProperty("bird.color");
        System.out.println(property);

        System.out.println("IOC容器创建完成.....");
    }

}
