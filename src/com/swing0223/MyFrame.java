package com.swing0223;

import steam.PictureView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame {
    public MyFrame(String title)
    {
        super(title);

        JPanel root = new JPanel();
        this.setContentPane( root );

        MyControl c = new MyControl();
        root.add( c );
        c.setPreferredSize(new Dimension(120,120));
        // 鼠标监听
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("mousePressed");
                System.out.println("位置" + e.getPoint());

                if (e.getButton() == MouseEvent.BUTTON1)
                    System.out.println("左键");
                if (e.getButton() == MouseEvent.BUTTON2)
                    System.out.println("中键");
                if (e.getButton() == MouseEvent.BUTTON3)
                    System.out.println("右键");
            }

        });
        // 不使用布局器
        Label acname = new Label("账户名称");

        // 设置Steam图标
        PictureView icon = new PictureView();
        root.add( icon );
        root.add( acname );
        icon.setImage("/res/img1.png");
        // 手工指定位置
        icon.setBounds(0,0,icon.getWidth(),icon.getHeight());
//        c.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                System.out.println("mousePressed");
//                System.out.println("位置" + e.getPoint());
//
//                if (e.getButton() == MouseEvent.BUTTON1)
//                    System.out.println("左键");
//                if (e.getButton() == MouseEvent.BUTTON2)
//                    System.out.println("中键");
//                if (e.getButton() == MouseEvent.BUTTON3)
//                    System.out.println("右键");
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });
    }
}
