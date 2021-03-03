//package proxy.dynamic;
//
//import cn.com.xbed.dao.mapper.AccountBillMapper;
//import proxy.statics.IPerson;
//import org.apache.ibatis.binding.MapperMethod;
//import org.apache.ibatis.binding.MapperProxy;
//import org.junit.Test;
//import sun.misc.ProxyGenerator;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.lang.reflect.*;
//import java.nio.file.Files;
//import java.nio.file.OpenOption;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.security.AccessController;
//import java.security.PrivilegedAction;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * @Date 2020/1/6 11:49
// * @Created by huangfl
// */
//public class TestMapperProxy {
//    private static final Class<?>[] constructorParams =
//            {InvocationHandler.class};
//
//    @Test
//    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        final Class<AccountBillMapper> mapperInterface = AccountBillMapper.class;
//        final Map<Method, MapperMethod> methodCache = new ConcurrentHashMap();
//        MapperProxy<AccountBillMapper> mapperProxy = new MapperProxy(null, AccountBillMapper.class, methodCache);
////        AccountBillMapper mapper = (AccountBillMapper) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
//        Class<?> cl;
////      查找或生成指定的代理类。
//        cl = Proxy.getProxyClass(mapperInterface.getClassLoader(), mapperInterface);
//        System.out.println(cl.getSuperclass().getName());
//        final Constructor<?> cons = cl.getConstructor(constructorParams);
//
//        Method[] methodArray = cl.getMethods();
//        for (Method m : methodArray) {
//            System.out.println(m);
//        }
//
//        cl = Proxy.getProxyClass(mapperInterface.getClassLoader(), IPerson.class);
//      methodArray = cl.getMethods();
//        for (Method m : methodArray) {
//            System.out.println(m);
//        }
//            AccountBillMapper mapper = (AccountBillMapper) cons.newInstance(new Object[]{mapperProxy});
//
////        IPerson iPerson = (IPerson) Proxy.newProxyInstance(IPerson.class.getClassLoader(),new Class[] {IPerson.class}, normalHandler);
//
//            System.out.println(mapper);
//
//    }
//
//    @Test
//    public void testProxyGenerator() throws UnsupportedEncodingException {
//        String var0="D:\\proxy.dynamic.Proxy";
//        byte[] var4 = ProxyGenerator.generateProxyClass(var0, new Class[]{AccountBillMapper.class}, 17);
////        ProxyGenerator var3 = new ProxyGenerator(var0, new Class[]{AccountBillMapper.class}, 17);
//
//        if (true) {
//            AccessController.doPrivileged(new PrivilegedAction<Void>() {
//                public Void run() {
//                    try {
//                        int var1 = var0.lastIndexOf(46);
//                        Path var2;
//                        if (var1 > 0) {
//                            Path var3 = Paths.get(var0.substring(0, var1).replace('.', File.separatorChar));
//                            Files.createDirectories(var3);
//                            var2 = var3.resolve(var0.substring(var1 + 1, var0.length()) + ".class");
//                        } else {
//                            var2 = Paths.get(var0 + ".class");
//                        }
//
//                        Files.write(var2, var4, new OpenOption[0]);
//                        return null;
//                    } catch (IOException var4x) {
//                        throw new InternalError("I/O exception saving generated file: " + var4x);
//                    }
//                }
//            });
//        }
////        System.out.println(new String(var4,"utf-8"));
//    }
//
//}
