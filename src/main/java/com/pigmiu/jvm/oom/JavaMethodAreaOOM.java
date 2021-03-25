package com.pigmiu.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: yli
 * @Date: 2018/8/29 16:25
 * VM Args: -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M (jdk8之前有持久代，用PermSize)
 * @Description:
 */
public class JavaMethodAreaOOM {

    static class MethodOOMObject{

    }

    public static void main(String[] args){
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MethodOOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }
}
