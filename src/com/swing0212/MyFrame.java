package com.swing0212;

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

        // 设置布局器
        root.setLayout( new BorderLayout());
        // 宽度占满 高度由setPreferredSize() 决定
        root.add(new ColorLabel("1", Color.YELLOW), BorderLayout.NORTH);
        root.add(new ColorLabel("2", Color.GREEN), BorderLayout.SOUTH);
        // 高度占满 宽度由setPreferredSize() 决定
        root.add(new ColorLabel("3", Color.GRAY), BorderLayout.WEST);
        root.add(new ColorLabel("4", Color.CYAN),BorderLayout.EAST);
        // 总是占满中央位置
        root.add(new ColorLabel("5",Color.black), BorderLayout.CENTER);
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

