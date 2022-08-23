package com.swing0204;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFrame extends JFrame {

    JLabel timeLabel = new JLabel("00:00:00");

    public MyFrame(String title) // 重写构造
    {
        super(title);

        // JPanel 容器
        JPanel root = new JPanel();
        // 给窗口设置容器
        this.setContentPane(root);
        //JButton 控件
        JButton button = new JButton("test");
        // 在面板(root)添加控件
        root.add(button);
        root.add(timeLabel);

        // 事件监听
            // 设置监听器
//        MyActionListener listener = new MyActionListener();
        // 多态写法
//        ActionListener listener = new MyActionListener();
//        button.addActionListener(listener);

        button.addActionListener(new MyActionListener());
    }
    // 添加一个监听类, 实现ActionListener接口
        // 内部类的写法
        // interface 不能直接使用 要派生一个子类
    private class MyActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            // 取得当前时间

            String timeStr = sdf.format(new Date());
//            System.out.println(timeStr);
            timeLabel.setText(timeStr);
        }
    }
}
