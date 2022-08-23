package com.swing0219;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    public MyFrame(String title)
    {
        super(title);
        JPanel root = new JPanel();
        this.setContentPane( root );

        // 使用自定义控件
        root.add(new SinCurve()).setPreferredSize(new Dimension(500, 500));

    }
}
