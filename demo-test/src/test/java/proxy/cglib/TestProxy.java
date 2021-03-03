package proxy.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Date 2020/1/13 11:21
 * @Created by huangfl
 */
public class TestProxy {

    interface A {
        public void test(String name);
    }

    @Test
    public void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(A.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    System.out.println("before method run...");
                    Object result = proxy.invokeSuper(obj, args);
                    System.out.println("after method run...");
                    return result;
            }
        });
        A a = (A) enhancer.create();
        Method[] methodArray = a.getClass().getMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }
        System.out.println(a.getClass().getDeclaringClass());
        System.out.println(a.getClass().getEnclosingClass());

        try {
            Class c=Class.forName(a.getClass().getCanonicalName());
            System.out.println(a);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
