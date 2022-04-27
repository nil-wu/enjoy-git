package cn.enjoy.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspects {

    @Pointcut("execution(public int cn.enjoy.spring.aop.Calculator.div(int,int))")
    public void pointCut(){};

    @Pointcut("execution(public int cn.enjoy.spring.aop.Calculator.*(..))")
    public void pointCut2(){};


    @Before("pointCut()")
    public void logStart(){
        System.out.println("除法运行....参数是：{}");
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("除法结束");
    }

    @AfterReturning("pointCut()")
    public void logReturn(){
        System.out.println("除法正常返回....运行结果是：{}");
    }

    @AfterThrowing("pointCut()")
    public void logException(){
        System.out.println("除法异常....异常信息是：{}");
    }


    @Around("pointCut()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) {
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }


}
