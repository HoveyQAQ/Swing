package com.swing0208;

import javax.swing.*;

public class MyFrame extends JFrame {
    // 创建 JCheckBox 复选框控件
    JCheckBox agreeField = new JCheckBox("同意用户协议");
    // 下一步按钮
    JButton nextbutton = new JButton("下一步");

    JTextField textField = new JTextField(20);
    public MyFrame(String title) // 重写构造
    {
        super(title);

        // JPanel 容器
        JPanel root = new JPanel();
        // 给窗口设置容器
        this.setContentPane(root);
        root.add(agreeField);
        root.add(nextbutton);
        // 界面初始化
        agreeField.setSelected( false );
        nextbutton.setEnabled( false );
        // 给CheckBox 复选框添加事件处理
        agreeField.addActionListener(e -> {
            if ( agreeField.isSelected() )
                nextbutton.setEnabled( true );
            else
                nextbutton.setEnabled( false);
        });
    }

}

