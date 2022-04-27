package cn.enjoy.spring.cap9.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sun {

    private Moon moon;

//    public Sun() {
//        System.out.println(toString());
//    }

//    @Autowired
    public Sun( Moon moon) {
        this.moon = moon;
        System.out.println("Sun....constructor....");
    }

    public Moon getMoon() {
        return moon;
    }

//    @Autowired
    public void setMoon(@Autowired Moon moon) {
        this.moon = moon;
    }

    @Override
    public String toString() {
        return "Sun{" +
                "moon=" + moon +
                '}';
    }
}
