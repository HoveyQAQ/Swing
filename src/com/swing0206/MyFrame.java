package com.swing0206;

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
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // 匿名内部类
//                showTime();
//            }
//        });
        // lambda表达式
        button.addActionListener(e -> {
            showTime();
        });
        // e 参数
        // {} 方法体
    }
    public void showTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        // 取得当前时间

        String timeStr = sdf.format(new Date());
//            System.out.println(timeStr);
        timeLabel.setText(timeStr);
    }
}

