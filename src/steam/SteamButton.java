package steam;

import javax.swing.*;
import java.awt.*;

public  class SteamButton extends JButton {
    public SteamButton(String text){
        //用构造方法设置按钮上的文字
        this.setText(text);
        this.setForeground( Color.GRAY );
        this.setBackground(new Color(60,65,74));//设置按钮颜色
        this.setBorderPainted(false);//去除边框
        this.setSize(new Dimension(162,22));//设置大小
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setFont(Font.getFont("等线"));
    }

}
