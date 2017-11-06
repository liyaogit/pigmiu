package com.design;

import com.design.command.*;
import org.junit.Test;

/**
 * User: yli
 * Date: 2017/6/12
 * Time: 12:27
 */
public class CommandTest {
    @Test
    public void SimpleRemoteControlTest(){
        SimpleRemoteControl client = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        client.setCommand(lightOn);
        client.buttonWasPressed();
    }

    @Test
    /*多卡槽遥控器测试*/
    public void RemoteControlTest(){
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);
        remoteControl.setCommand(0, lightOn, lightOff);
        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);

        remoteControl.undoButtonWasPushed();

        //宏命令测试
        System.out.print("宏命令测试开始");
        Command[] partyOn = {lightOn,lightOn};
        Command[] partyOff = {lightOff,lightOff}; //尴尬还是只有一个命令

        MacroCommand macroCommandOn = new MacroCommand(partyOn);
        MacroCommand macroCommandOff = new MacroCommand(partyOff);

        remoteControl.setCommand(2, macroCommandOn, macroCommandOff);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.undoButtonWasPushed();
    }
}
