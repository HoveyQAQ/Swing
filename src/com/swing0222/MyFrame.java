package com.swing0222;

import swing.PictureView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MyFrame extends JFrame{
    public MyFrame(String title)
    {
        super(title);
        JPanel root = new JPanel();
        this.setContentPane( root );

        // 使用自定义控件
        PictureView c = new PictureView();
        root.add(c);
        c.setPreferredSize( new Dimension(200, 200));
        // 设置背景色
        c.setBackgroundColor( Color.WHITE);
        // 加载资源文件
        c.setImage("/res/2.png");


        // 设置要显示的图片

    }
}
