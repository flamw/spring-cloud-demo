package cn.com.xbed.test.aop;

import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.springframework.aop.TargetSource;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.target.SingletonTargetSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Date 2020/1/9 9:43
 * @Created by huangfl
 */
public class TestAop {

    ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfigAOP.class);
    @Test
    public void shouldAnswerWithTrue()
    {
      MyAop bean = ioc.getBean(MyAop.class);
//        MyAop bean = new MyAop();
        bean.div(1,1);
    }

    @Test
    public  void proxy(){
//        AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator=new AnnotationAwareAspectJAutoProxyCreator();
//        MyAop bean = new MyAop();
//        Object[] specificInterceptors = annotationAwareAspectJAutoProxyCreator.getAdvicesAndAdvisorsForBean(MyAop.class, "MyAop", (TargetSource)null);
//        if (specificInterceptors != DO_NOT_PROXY) {
//            Object proxy = annotationAwareAspectJAutoProxyCreator.createProxy(bean.getClass(), beanName, specificInterceptors, new SingletonTargetSource(bean));
//            this.proxyTypes.put(cacheKey, proxy.getClass());
//            return proxy;
    }
}
