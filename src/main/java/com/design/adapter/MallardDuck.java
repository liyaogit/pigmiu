package com.design.adapter;

import java.awt.peer.SystemTrayPeer;

/**
 * User: yli
 * Date: 2017/6/15
 * Time: 15:32
 */
public class MallardDuck implements Duck {
    public void quack() {
        System.out.println("嘎嘎嘎");
    }

    public void fly() {
        System.out.println("我要飞了");
    }
}
