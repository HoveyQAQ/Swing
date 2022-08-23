package com.swing0224;

import javax.swing.*;
import java.awt.*;

public class MyControl extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);// 保留

        int width = this.getWidth();
        int height = this.getHeight();
        g.setColor(new Color(0xFFFFF0));
        g.fillRect(0, 0, width, height);
    }
}
