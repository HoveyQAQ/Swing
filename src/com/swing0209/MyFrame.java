package com.swing0209;

import javax.swing.*;

public class MyFrame extends JFrame {
    // JComboBox 下拉列表控件
    JComboBox<String> colorField = new JComboBox<>();JTextField textField = new JTextField(20);
    public MyFrame(String title) // 重写构造
    {
        super(title);

        // JPanel 容器
        JPanel root = new JPanel();
        // 给窗口设置容器
        this.setContentPane(root);

        // 添加数据项
        colorField.addItem("红");
        colorField.addItem("黄");
        colorField.addItem("蓝");
        root.add(colorField);
        // - getItemCount() 数据项个数
        // - getItemAt( index ) 获取数据项
        // 测试按钮
        JButton testButton = new JButton();
        root.add( testButton );
        testButton.addActionListener(e -> {
            test();
        });
    }
    public void test()
    {

    }
}

