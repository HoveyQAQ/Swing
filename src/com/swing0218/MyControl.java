package com.swing0218;

import javax.swing.*;
import java.awt.*;

public class MyControl extends JPanel {
    // 重写绘制方法 paintComponent() ctrl + o
    // 是paintComponent() 不是 printComponent()
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);// 保留

        int width = this.getWidth();
        int height = this.getHeight();
        // 底色设置为白色
        g.setColor(new Color(0xFFFFFFF));
        g.fillRect(0, 0, width, height);
        // 绘制矩形
        g.setColor(new Color(0xFF00000));
        g.fillRect(30,30,100,50);
        // 绘制椭圆
            //长轴短轴设置为一样的就可以绘制圆形
        g.setColor(Color.RED);
        g.fillOval(30, 80, 100, 50);
        // 绘制扇形
        g.setColor(Color.RED);
        // 前四个参数指定外围矩形 后两个参数 startAngle: 起始角度 arcAngle: 圆弧角度
        g.fillArc(30, 130, 100, 50, 0, 120);
        // fill 填充 draw 描边
        g.setColor(new Color(0xFF00000));
        g.drawRect(130,30,100,50);
        g.setColor(Color.RED);
        g.drawOval(130, 80, 100, 50);
        g.setColor(Color.RED);
        g.drawArc(130, 130, 100, 50, 0, 120);
//        g.drawLine(); 绘制线段
//        g.drawImage(); 绘制图片
//        g.drawPolygon(); 绘制多边形
//        g.drawString(); 绘制文字
    }
}
