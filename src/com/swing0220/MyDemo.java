package com.swing0220;

import javax.swing.*;

public class MyDemo {
    public static void main(String[] args) {
        JFrame frame = new MyFrame("example");

        // 关闭窗口时 退出整个程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置窗口大小
        frame.setSize(600,600);
        // 显示窗口
        frame.setVisible(true);
    }
}
