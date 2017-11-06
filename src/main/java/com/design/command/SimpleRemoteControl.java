package com.design.command;

/**
 * User: yli
 * Date: 2017/6/12
 * Time: 12:22
 * 使用命令的对象(client),此处模拟一个遥控器按钮例子
 */
public class SimpleRemoteControl {
    Command slot;

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
