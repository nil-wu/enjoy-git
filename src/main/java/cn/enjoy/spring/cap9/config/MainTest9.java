package cn.enjoy.spring.cap9.config;

import cn.enjoy.spring.cap9.bean.Moon;
import cn.enjoy.spring.cap9.bean.Sun;
import cn.enjoy.spring.cap9.dao.TestDao;
import cn.enjoy.spring.cap9.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest9 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Cap9MainConfig.class);
//        TestDao testDao1 = (TestDao)ac.getBean("testDao");
//        TestService testService = (TestService)ac.getBean("testService");
//
//        System.out.println(testDao1 == testService.getTestDao());

//        TestDao testDao = (TestDao)ac.getBean(TestDao.class);
//        System.out.println(testDao);

        TestService testService = (TestService)ac.getBean("testService");
        testService.printLn();

        Moon moon = ac.getBean(Moon.class);
        System.out.println(moon);

        Sun sun = ac.getBean(Sun.class);
        System.out.println(sun.getMoon());

    }

}
