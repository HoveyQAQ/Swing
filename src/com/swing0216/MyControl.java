package com.swing0216;

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
        g.setColor(new Color(255, 0, 0));
        g.fillRect(0, 0, width, height);
    }
}
