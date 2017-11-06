package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: yli
 * Date: 2017/8/23
 * Time: 16:24
 */
public class MyGui {
    JLabel jLabel;
    JFrame frame;
    public static void main(String[] args){
        MyGui gui = new MyGui();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        jLabel = new JLabel("你说我显示啥");

        JButton button1 = new JButton("改变颜色");
        JButton button2 = new JButton("改变文案");

        button1.addActionListener(new ColorListener()); //观察者模式,注册加入按钮的监听者列表
        button2.addActionListener(new LabelListener()); //传入内部实例

        button2.addActionListener(new ActionListener() {   //把整个类当参数传进去
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //窗口关闭把程序结束掉

        frame.getContentPane().add(new MyDrawPanel()); //默认中心区域
        frame.getContentPane().add(BorderLayout.SOUTH,button1);  //放最下面
        frame.getContentPane().add(BorderLayout.EAST,button2);
        frame.getContentPane().add(BorderLayout.WEST,jLabel);
        frame.setSize(600,600);

        frame.setVisible(true);
    }

    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            jLabel.setText("你点了!!!");
        }
    }

    /**
     *定义内部类,共享外部类的实例变量
     */
    class ColorListener implements ActionListener{
        //实现通知后的方法
        public void actionPerformed(ActionEvent e) {
            frame.repaint();   //重新调用widget的paintComponent方法
        }
    }

}
