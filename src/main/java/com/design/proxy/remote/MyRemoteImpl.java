package com.design.proxy.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * User: yli
 * Date: 2017/7/27
 * Time: 17:02
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    public MyRemoteImpl() throws RemoteException { //继承超累的构造器异常
    }

    public String sayHello() {
        return "hello world";
    }
}
