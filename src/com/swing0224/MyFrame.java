package com.swing0224;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
                System.out.println("mousePressed-----");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased----");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked-----");
            }
        });

    }
}
