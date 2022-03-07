package cn.enjoy.spring.cap7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Cap7Config {

    @Scope(value = "prototype")
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Bike bike(){
        return new Bike();
    }


}
