package cn.enjoy.spring.cap2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(value = "cn.enjoy.spring.cap2",includeFilters = {
        @Filter(type = FilterType.CUSTOM,classes = {JamesTypeFilter.class})
},useDefaultFilters = false)
public class MainConfig2 {
}
