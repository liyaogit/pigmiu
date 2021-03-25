package com.pigmiu.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User: yli
 * Date: 2017/7/28
 * Time: 15:49
 */
public class NonOwnerInvocationHandler implements InvocationHandler {
    PersonBean personBean;

    public NonOwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("setHotOrNot")){
            return method.invoke(personBean, args);
        } else {
            throw new IllegalAccessException();
        }
    }
}
