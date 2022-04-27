package cn.enjoy.spring.cap3.config;

import cn.enjoy.spring.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Cap3MainConfig {

    /**
     * 给容器注册一个bean，类型为返回值的类型，默认是单实例
     * @return
     */
    @Scope("prototype")
    @Bean
    public Person person(){
        return new Person("james", 20);
    }

}
