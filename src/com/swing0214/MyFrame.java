package com.swing0214;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    public MyFrame(String title)
    {
        super(title);

        JPanel root = new JPanel();
        this.setContentPane( root );

        ColorLabel a1 = new ColorLabel("ABC", Color.CYAN);
        // 不使用布局器
        root.setLayout( null );

        root.add( a1 );
        // 手工指定位置
        a1.setBounds(300,0,100,50);

    }
}
