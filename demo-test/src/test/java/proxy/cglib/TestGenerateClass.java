package cn.com.xbed.test.proxy.cglib;

import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.core.DefaultGeneratorStrategy;
import org.springframework.cglib.core.GeneratorStrategy;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @Date 2020/1/13 14:55
 * @Created by huangfl
 */
public class TestGenerateClass {

  public void testName(String name){
      System.out.println(name);
  }
    @Test
    public void test() throws Exception {
        Enhancer enhancer = new Enhancer();
//        DebuggingClassWriter dubuggingClassWriter=new DebuggingClassWriter();
        GeneratorStrategy strategy = DefaultGeneratorStrategy.INSTANCE;
        enhancer.setSuperclass(TestGenerateClass.class);
        Callback[] callbacks = new Callback[]{new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("after method run...");
                return result;
            }
        }};
        enhancer.setCallbacks(callbacks);
        enhancer.create();
        byte[] var4 = enhancer.getStrategy().generate(enhancer);
        String var0="D:\\workspace\\account\\web\\src\\test\\cn.com.xbed.test.proxy.cglib.proxy$";

        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    int var1 = var0.lastIndexOf(46);
                    Path var2;
                    if (var1 > 0) {
                        Path var3 = Paths.get(var0.substring(0, var1).replace('.', File.separatorChar));
                        Files.createDirectories(var3);
                        var2 = var3.resolve(var0.substring(var1 + 1, var0.length()) + ".class");
                    } else {
                        var2 = Paths.get(var0 + ".class");
                    }

                    Files.write(var2, var4, new OpenOption[0]);
                    return null;
                } catch (IOException var4x) {
                    throw new InternalError("I/O exception saving generated file: " + var4x);
                }
            }
        });
//        String className = ClassNameReader.getClassName(new ClassReader(b));
//        this.getClassNameCache(loader).add(className);
//        gen = ReflectUtils.defineClass(className, b, loader);
    }
}
