package com.design.command;

/**
 * User: yli
 * Date: 2017/6/12
 * Time: 15:47
 */
public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    public void execute() {
        System.out.println("\n宏命令开始执行");
        for(Command command : commands){
            command.execute();
        }
    }

    public void undo() {
        System.out.println("宏命令撤销:开始执行");
        for (Command command : commands){
            command.undo();
        }
    }
}
