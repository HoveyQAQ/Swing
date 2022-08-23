package com.swing0215;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    public MyFrame(String title)
    {
        super(title);

        JPanel root = new JPanel();
        this.setContentPane( root );
        root.setLayout(new SimpleLayout());
        root.add(new ColorLabel("1", Color.YELLOW));
        root.add(new ColorLabel("2", Color.GREEN));
        root.add(new ColorLabel("3", Color.GRAY));
        root.add(new ColorLabel("4", Color.CYAN));
        root.add(new ColorLabel("5",Color.black));


    }
}
