package cn.enjoy.spring.cap5.config;

import cn.enjoy.spring.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Cap5MainConfig {

    @Bean("james")
    public Person james(){
        System.out.println("给容器中添加james");
        return new Person("james", 20);
    }

    @Conditional(value = WinCondition.class)
    @Bean("lison")
    public Person lison(){
        System.out.println("给容器中添加lison");
        return new Person("lison", 20);
    }

}
