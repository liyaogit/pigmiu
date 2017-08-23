package com.design.command;

/**
 * User: yli
 * Date: 2017/6/12
 * Time: 14:11
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
    public void undo() {
        light.on();
    }
}
