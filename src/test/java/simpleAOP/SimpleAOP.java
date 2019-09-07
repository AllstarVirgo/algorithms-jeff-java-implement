package simpleAOP;

import java.lang.reflect.Proxy;

public class SimpleAOP {
    public static Object testService(Object target,Advice advice){
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),target.getClass().getInterfaces(),advice);
    }
}
