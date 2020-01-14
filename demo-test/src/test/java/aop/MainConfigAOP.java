package cn.com.xbed.test.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy//开启基于注解的aop模式
@Configuration
public class MainConfigAOP {

    @Bean
    public MyAop myAop() {
        return new MyAop();
    }
    @Bean
    public LogAOP logAOP(){
        return new LogAOP();
    }

}
 
