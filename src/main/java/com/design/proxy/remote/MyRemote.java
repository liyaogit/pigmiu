package com.design.proxy.remote;

import java.rmi.Remote;

/**
 * User: yli
 * Date: 2017/7/27
 * Time: 15:30
 */
public interface MyRemote extends Remote {
    String sayHello() throws RuntimeException;   //所有远程接口必须声明该异常
}
