package com.swing0207;

import javax.swing.*;

public class MyFrame extends JFrame {

    JTextField textField = new JTextField(20);
    public MyFrame(String title) // 重写构造
    {
        super(title);

        // JPanel 容器
        JPanel root = new JPanel();
        // 给窗口设置容器
        this.setContentPane(root);
        // 创建 JTextField控件

        root.add(textField);
//        root.add(new JTextField(20));
        textField.setText("Hovey");

        JButton button = new JButton("ok");
        root.add(button);
        button.addActionListener(e -> {
            test();
        });
    }
    public void test()
    {
        String str = textField.getText();
        System.out.println(str);
    }
}

