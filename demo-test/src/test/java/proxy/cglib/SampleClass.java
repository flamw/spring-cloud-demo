package proxy.cglib;

import aop.MyAop;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SampleClass {
    public void test(){
        System.out.println("hello world");
    }
 
    public static void main(String[] args) {
        MyAop bean = new MyAop();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("after method run...");
                Object result2 =method.invoke(obj, args);
                System.out.println(result2);
                return result;
            }
        });
        SampleClass sample = (SampleClass) enhancer.create();
        sample.test();

        Method[] methodArray = SampleClass.class.getMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }

    }


    public void testBeanGenerator() throws Exception {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setValue", String.class);
        setter.invoke(myBean, "Hello cglib niu bi");

        Method getter = myBean.getClass().getMethod("getValue");
        System.out.println(getter.invoke(myBean));
//        Assert.assertEquals("Hello cglib", getter.invoke(myBean));
    }
}
