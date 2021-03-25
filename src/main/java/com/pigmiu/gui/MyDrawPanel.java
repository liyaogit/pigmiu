package com.pigmiu.gui;

import javax.swing.*;
import java.awt.*;

/**
 * User: yli
 * Date: 2017/8/24
 * Time: 15:54
 */
public class MyDrawPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;  //实际上是个2D的对象
        g.setColor(Color.BLACK);
        g.fillRect(0,0,600,600); //填充尺寸和颜色

        GradientPaint gradientPaint = new GradientPaint(100,130,randomColor(), 250, 150, randomColor()); //渐变对象

        g2d.setPaint(gradientPaint);
        g2d.fillOval(70,70,300,300);  //画椭圆

    }

    private static Color randomColor(){
        int red = (int) (Math.random()*255);
        int green = (int) (Math.random()*255);
        int blue = (int) (Math.random()*255);
        return new Color(red,green,blue);
    }
}
