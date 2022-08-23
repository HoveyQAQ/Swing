package com.swing0217;

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
        g.setColor(new Color(0xFF0000));
        g.fillRect(0, 0, width, height);
        g.setColor(new Color(0, 0, 255, 66));
        g.fillRect(50,50,60,30);
    }
}
