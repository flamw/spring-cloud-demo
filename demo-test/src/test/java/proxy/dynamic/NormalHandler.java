package proxy.dynamic;

import cn.com.xbed.dao.mapper.AccountBillMapper;
import proxy.statics.IPerson;
import proxy.statics.Man;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.binding.MapperProxy;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date 2020/1/3 16:22
 * @Created by huangfl
 */
public class NormalHandler implements InvocationHandler {

    private Object target;

    public NormalHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }

    public static void main(String[] args) {
//        Man man = new Man();
//        NormalHandler normalHandler = new NormalHandler(man);
//        AnnotationHandler annotationHandler = new AnnotationHandler();
//        IPerson iPerson = (IPerson) Proxy.newProxyInstance(IPerson.class.getClassLoader(),new Class[] {IPerson.class}, normalHandler);
//        iPerson.say();
        InvocationHandlerTest invocationHandlerTest=new InvocationHandlerTest();
        Test test = (Test) Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[] {Test.class}, invocationHandlerTest);
        test.test1("hello world");
    }

    public interface Test{
        public void test1(String  name);
    }


    public static class InvocationHandlerTest implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }





}
