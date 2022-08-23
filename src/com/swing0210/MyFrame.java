package com.swing0210;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(String title) // 重写构造
    {
        super(title);

        // JPanel 容器
        JPanel root = new JPanel();
        // 给窗口设置容器
        this.setContentPane(root);
        JLabel label = new JLabel();
        root.add(label);
        label.setText("hh");
        // 字体
        // 风格 Font.PLAIN Font.BOLD
        // 字号
        label.setFont(new Font("微软雅黑",Font.PLAIN,14));
        // 颜色
        label.setForeground(new Color(255, 255, 255));
        label.setOpaque(true);// 背景不要透明
        label.setBackground(new Color(0,0,0));
        // 控件大小
        label.setPreferredSize(new Dimension(160, 30));
        // 水平方向对齐
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }
}

