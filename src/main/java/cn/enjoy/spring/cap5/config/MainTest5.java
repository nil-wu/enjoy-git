package cn.enjoy.spring.cap5.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest5 {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Cap5MainConfig.class);
//        ac.getBean("");
        System.out.println("容器创建完成");
    }

}
