package com.design.command;

/**
 * User: yli
 * Date: 2017/6/12
 * Time: 12:06
 * 命令抽象接口
 */
public interface Command {
    void execute();

    void undo();
}
