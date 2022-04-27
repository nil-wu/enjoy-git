package cn.enjoy.spring.cap7.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Jeep {

    public Jeep(){
        System.out.println("Jeep....constructor....");
    }

    @PostConstruct
    public void init(){
        System.out.println("Jeep....PostConstruct....");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Jeep....PreDestroy....");
    }

}
