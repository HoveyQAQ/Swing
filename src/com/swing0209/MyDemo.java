package com.swing0209;

import javax.swing.*;

public class MyDemo {
    public static void main(String[] args) {
        // JFrame 一个窗口 参数为窗口标题
//        JFrame frame = new JFrame("Swing Example");

//        MyFrame frame = new MyFrame("Example");
        // 多态: 子类的实例具有父类的所有特征
        // 实例的真实类型:MyFrame
        // 实例的名义类型:JFrame
        JFrame frame = new MyFrame("example");

        // 关闭窗口时 退出整个程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置窗口大小
        frame.setSize(250,250);
        // 显示窗口
        frame.setVisible(true);

    }
}