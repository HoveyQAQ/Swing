package com.swing0213;

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
        // 设置水平布局器
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

