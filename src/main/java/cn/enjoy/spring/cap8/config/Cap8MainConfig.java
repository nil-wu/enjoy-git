package cn.enjoy.spring.cap8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/test.properties")
public class Cap8MainConfig {

    @Bean
    public Bird bird() {
        return new Bird();
    }

}
