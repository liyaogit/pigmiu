package com.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User: yli
 * Date: 2017/7/28
 * Time: 15:38
 */
public class OwnerInvocationHandler implements InvocationHandler {
    PersonBean personBean ;

    public OwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")){
            return method.invoke(personBean,args);
        }else if (method.getName().startsWith("setHotOrNot")){
            throw new IllegalAccessException();
        }else if (method.getName().startsWith("set")){
            return method.invoke(personBean,args);
        }
        return null;
    }
}
