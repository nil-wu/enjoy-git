package cn.enjoy.spring.cap5.config;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WinCondition implements Condition {

    /**
     * ConditionContext：判断条件可以使用的上下文（环境）
     * AnnotatedTypeMetadata：注解的信息
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();

        Environment environment = conditionContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        if("Mac OS X".equals(property)){
            return true;
        }
        return false;
    }
}
