package com.gui;

import javax.swing.*;
import java.awt.*;

/**
 * User: yli
 * Date: 2017/8/25
 * Time: 14:53
 */
public class MySwing {

    private static void go(){
        JFrame frame = new JFrame(); //框架

        JPanel jPanel = new JPanel(); //面板   默认FlowLayout布局管理
        jPanel.setBackground(Color.DARK_GRAY);
        JButton button = new JButton("啊呵呵呵");
        JButton button2 = new JButton("第二个在哪");
        JButton button3 = new JButton("再来一个看你放哪");
        jPanel.add(button);            //按钮放在面板上
        jPanel.add(button2);
        jPanel.add(button3);

        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS)); //设置BoxLayout布局

        frame.getContentPane().add(BorderLayout.EAST,jPanel);  // 框架 BorderLayout布局
        frame.setSize(300,300);
//        frame.pack();  //window大小符合组件大小
        frame.setVisible(true);
    }

    public static void main(String[] args){
        MySwing mySwing = new MySwing();
        mySwing.go();
    }
}
