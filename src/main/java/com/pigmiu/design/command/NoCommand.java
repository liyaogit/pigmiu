package com.pigmiu.design.command;

/**
 * User: yli
 * Date: 2017/6/12
 * Time: 14:26
 */
public class NoCommand implements Command {
    public void execute() {
        System.out.print("还没有设置命令");
    }

    public void undo() {

    }
}
