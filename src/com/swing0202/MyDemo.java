package com.swing0202;

import javax.swing.*;

public class MyDemo {
    public static void main(String[] args) {
        // JFrame 一个窗口 参数为窗口标题
        JFrame frame = new JFrame("Swing Example");
        // 关闭窗口时 退出整个程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JPanel 容器
        JPanel root = new JPanel();
        // 给窗口设置容器
        frame.setContentPane(root);
        //JButton 控件
        JButton button = new JButton("test");
        //JLabel 标签控件
        JLabel label = new JLabel("浩浩");
        // 在面板(root)添加控件
        root.add(button);
        root.add(label);
        // 另一种写法
        root.add(new JLabel("hahaha"));
        // 设置窗口大小
        frame.setSize(250,250);
        // 显示窗口
        frame.setVisible(true);

    }
}
