package cn.enjoy.spring.cap9.config;

import cn.enjoy.spring.cap9.dao.TestDao;
import cn.enjoy.spring.cap9.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({
        "cn.enjoy.spring.cap9.controller",
        "cn.enjoy.spring.cap9.service",
        "cn.enjoy.spring.cap9.dao",
        "cn.enjoy.spring.cap9.bean"
})
public class Cap9MainConfig {

    @Primary
    @Bean("testDao2")
    public TestDao testDao() {
        TestDao testDao = new TestDao();
        testDao.setFlag("2");

        return testDao;
    }

}
