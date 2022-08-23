package com.swing0220;

import swing.PictureView1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyFrame extends JFrame{
    public MyFrame(String title)
    {
        super(title);

        // 使用自定义控件
        // 以自身作为根容器
        PictureView1 c = new PictureView1();
        this.setContentPane(c);
        // 设置背景色
        c.setBackgroundColor( Color.cyan);
        // 设置要显示的图片
        try {
            // 加载图片对象 (应放在构造方法中)
            Image image = ImageIO.read(new File("data/1.JPG"));
            c.setImage( image) ;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
