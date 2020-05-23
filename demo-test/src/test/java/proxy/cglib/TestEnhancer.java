package proxy.cglib;

import org.junit.Test;
import org.springframework.asm.Type;
import org.springframework.cglib.core.*;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Date 2020/1/9 16:45
 * @Created by huangfl
 */
public class TestEnhancer {
  Type CALLBACK_ARRAY = org.springframework.asm.Type.getType(Callback[].class);
    Signature  SET_THREAD_CALLBACKS;
    {
        SET_THREAD_CALLBACKS = new Signature("CGLIB$SET_THREAD_CALLBACKS", Type.VOID_TYPE, new Type[]{CALLBACK_ARRAY});
    }

    Signature NEW_INSTANCE = new Signature("newInstance", Constants.TYPE_OBJECT, new Type[]{CALLBACK_ARRAY});

    private void emitNewInstanceCallbacks() {
        ClassEmitter ce=new ClassEmitter();
        Class sc = SampleClass.class;
        ce.begin_class(46, 1, SampleClass.class.getName(), Type.getType(sc), TypeUtils.getTypes(new Class[] {sc}), "<generated>");

        CodeEmitter e = ce.begin_method(1, NEW_INSTANCE, (Type[])null);
//        Type thisType = this.getThisType(e);
        Type thisType = Type.getType(SampleClass.class);
        e.load_arg(0);
        e.invoke_static(thisType, SET_THREAD_CALLBACKS);
        this.emitCommonNewInstance(e);
    }


    private void emitCommonNewInstance(CodeEmitter e) {
        Type thisType = Type.getType(SampleClass.class);
        e.new_instance(thisType);
        e.dup();
        e.invoke_constructor(thisType);
        e.aconst_null();
        e.invoke_static(thisType, SET_THREAD_CALLBACKS);
        e.return_value();
        e.end_method();
    }
    @Test
    public void test() {

        Enhancer enhancer = new Enhancer();

        emitNewInstanceCallbacks();


        Callback[] callbacks = new Callback[]{new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("after method run...");
                return result;
            }
        }};


        Object var2;
        Class type=SampleClass.class;
        try {
            setThreadCallbacks(SampleClass.class, callbacks);

                var2 = ReflectUtils.newInstance(type);

//            var2 = ReflectUtils.newInstance(type, this.argumentTypes, this.arguments);
        } finally {
            setThreadCallbacks(type, (Callback[])null);
        }
        setThreadCallbacks(SampleClass.class,callbacks);

        SampleClass sampleClass= (SampleClass) var2;
        sampleClass.test();

    }

    private static void setThreadCallbacks(Class type, Callback[] callbacks) {
        setCallbacksHelper(type, callbacks, "CGLIB$SET_THREAD_CALLBACKS");
    }

    private static void setCallbacksHelper(Class type, Callback[] callbacks, String methodName) {
        try {
            Method setter = getCallbacksSetter(type, methodName);
            setter.invoke((Object) null, callbacks);
        } catch (Exception var4) {
          var4.printStackTrace();
        }
    }

    private static Method getCallbacksSetter(Class type, String methodName) throws NoSuchMethodException {
        return type.getDeclaredMethod(methodName, Callback[].class);
    }


}
