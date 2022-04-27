package cn.enjoy.spring.cap8.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Bird {

    @Value("james")
    private String name;
    @Value("#{1+3}")
    private Integer age;

    @Value("${bird.color}")
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Bird() {
    }

    public Bird(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
