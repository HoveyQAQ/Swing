package com.swing0203;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(String title) // 重写构造
    {
        super(title);

        // JPanel 容器
        JPanel root = new JPanel();
        // 给窗口设置容器
        this.setContentPane(root);
        //JButton 控件
        JButton button = new JButton("test");
        //JLabel 标签控件
        JLabel label = new JLabel("浩浩");
        // 在面板(root)添加控件
        root.add(button);
        root.add(label);
        // 另一种写法
        root.add(new JLabel("hahaha"));
    }
}
