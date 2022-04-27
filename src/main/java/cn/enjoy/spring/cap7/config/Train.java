package cn.enjoy.spring.cap7.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Train implements InitializingBean, DisposableBean {

    public Train() {
        System.out.println("Train....constructor....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Train ....destroy....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Train ....afterPropertiesSet....");
    }
}
