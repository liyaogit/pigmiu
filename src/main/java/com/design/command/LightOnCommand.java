package com.design.command;

/**
 * User: yli
 * Date: 2017/6/12
 * Time: 12:15
 * 命令具体实现类
 */
public class LightOnCommand implements Command{
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
