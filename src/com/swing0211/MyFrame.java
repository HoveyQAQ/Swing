package com.swing0211;

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
        // Color.YELLOW 常量对象 (public static final)
        // 相当于 new Color(255, 255, 0)
//        JLabel a1 = new JLabel("1");
//        a1.setOpaque(true);
//        a1.setBackground(Color.YELLOW);
//        a1.setPreferredSize(new Dimension(60, 30));
//        a1.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JLabel a2 = new JLabel("2");
//        a2.setOpaque(true);
//        a2.setBackground(Color.GREEN);
//        a2.setPreferredSize(new Dimension(60, 30));
//        a2.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JLabel a3 = new JLabel("3");
//        a3.setOpaque(true);
//        a3.setBackground(Color.GRAY);
//        a3.setPreferredSize(new Dimension(60, 30));
//        a3.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JLabel a4 = new JLabel("4");
//        a4.setOpaque(true);
//        a4.setBackground(Color.CYAN);
//        a4.setPreferredSize(new Dimension(60, 30));
//        a4.setHorizontalAlignment(SwingConstants.CENTER);

        root.add(new ColorLabel("1", Color.YELLOW));
        root.add(new ColorLabel("2", Color.GREEN));
        root.add(new ColorLabel("3", Color.GRAY));
        root.add(new ColorLabel("4", Color.CYAN));
    }
    private static class ColorLabel extends JLabel
    {
        public ColorLabel(String text, Color bgColor)
        {
            this.setText(text);
            this.setOpaque(true);
            this.setBackground( bgColor );
            this.setPreferredSize(new Dimension(60, 30));
            this.setHorizontalAlignment(SwingConstants.CENTER);
        }
    }
}

