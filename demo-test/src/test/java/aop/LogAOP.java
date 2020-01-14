package cn.com.xbed.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect//告诉spring这是一个切面类
public class LogAOP {

    @Pointcut(value = "execution(public * cn.com.xbed.test.aop.MyAop.*(..))")
    public void point() {
    }

    @Before("point()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + "方法运行了，参数列表是:[" + Arrays.asList(args) + "]");
    }

    @After("point()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "方法结束");
    }

    @AfterReturning(value = "point()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "方法正常返回,返回值[" + result + "]");

    }

    @AfterThrowing(value = "point()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + "方法出现异常,异常信息：[" + exception.getMessage() + "]");
    }
}
