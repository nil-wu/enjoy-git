package cn.enjoy.spring.cap1.config;

import cn.enjoy.spring.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig1 {

    @Bean("person3")
    public Person person2(){
        return new Person("james",20);
    }


}
