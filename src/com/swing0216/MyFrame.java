package com.swing0216;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    public MyFrame(String title)
    {
        super(title);
        JPanel root = new JPanel();
        this.setContentPane( root );

        // 使用自定义控件
        MyControl c = new MyControl();
        root.add(c);
        c.setPreferredSize(new Dimension(100,50));
    }
}
