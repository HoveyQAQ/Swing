package steam;

import javax.swing.*;
import java.awt.*;

public class BuyButton extends JButton {
    public BuyButton(){
        this.setText("购买");
        this.setBackground(new Color(142,214,41));  //设置颜色
        this.setForeground(Color.GRAY);  //设置字体颜色
        this.setFont(new Font("等线",Font.BOLD,13));  //设置字体
        this.setBorderPainted(false);  //去除边框
        this.setHorizontalAlignment(SwingConstants.CENTER);  //文字居中
    }
}
