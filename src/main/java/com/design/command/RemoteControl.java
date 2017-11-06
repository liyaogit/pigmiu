package com.design.command;

/**
 * User: yli
 * Date: 2017/6/12
 * Time: 14:19
 * 这才是真实的遥控器，多个卡槽，每个卡槽两个按键
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for(int i = 0; i < 7; i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot){
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    //撤销按钮
    public void undoButtonWasPushed(){
        undoCommand.undo();
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("\n------------------开始遥控-----------------\n");
        for(int i = 0; i < onCommands.length; i++){
            sb.append("[卡槽").append(i).append("]").append(onCommands[i].getClass().getName())
                    .append("    ").append(offCommands[i].getClass().getName()).append("\n");
        }
        sb.append("撤销:").append(undoCommand.getClass().getName()).append("\n");
        return sb.toString();
    }
}
