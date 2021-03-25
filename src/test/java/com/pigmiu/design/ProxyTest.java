package com.pigmiu.design;

import com.pigmiu.design.proxy.dynamic.NonOwnerInvocationHandler;
import com.pigmiu.design.proxy.dynamic.OwnerInvocationHandler;
import com.pigmiu.design.proxy.dynamic.PersonBean;
import com.pigmiu.design.proxy.dynamic.PersonBeanImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * User: yli
 * Date: 2017/7/28
 * Time: 16:04
 */
public class ProxyTest {
    @Test
    public void testDymaticProxy(){
        PersonBean person = getBasePersonInfo();
        PersonBean ownerProxy = getOwnerProxy(person);
        PersonBean nonOwnerProxy = getNonOwnerProxy(person);
        try {
            ownerProxy.setInterests("码代码");
            System.out.println(ownerProxy.getInterests());
            nonOwnerProxy.setInterests("喝尿");
            System.out.println(ownerProxy.getInterests());
        }catch (Exception e){
            System.out.println("没有权限");
        }
        try {
//            ownerProxy.setHotOrNot(100);
//            System.out.println(ownerProxy.getHotOrNot());
            nonOwnerProxy.setHotOrNot(1);
            System.out.println(ownerProxy.getHotOrNot());
        }catch (Exception e){
            System.out.println("没有权限");
        }


    }

    private PersonBeanImpl getBasePersonInfo(){
        PersonBeanImpl person = new PersonBeanImpl();
        person.setName("猪小米");
        person.setGender("男");
        person.setInterests("呵呵");
        person.setHotOrNot(7);
        return person;
    }

    //创建动态Proxy
    private PersonBean getOwnerProxy(PersonBean personBean){
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),personBean.getClass().getInterfaces(), new OwnerInvocationHandler(personBean));
    }

    private PersonBean getNonOwnerProxy(PersonBean personBean){
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),personBean.getClass().getInterfaces(), new NonOwnerInvocationHandler(personBean));
    }
}
