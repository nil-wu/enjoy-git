package cn.enjoy.spring.cap9.bean;

import org.springframework.stereotype.Component;

@Component
public class Moon {

    public Moon(){
        System.out.println("Moon constructor....");
    }

    public void init(){
        System.out.println("Moon...init...");
    }

    public void destory(){
        System.out.println("Moon...destory...");
    }

}
