package steam;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame {
    JPanel root = new JPanel();
    public UserFrame (String name)
    {
        super( "用户信息" );

        root.setBackground(new Color(42, 45, 50));
        this.setContentPane( root );
//        this.setLocationRelativeTo(null);
        root.setLayout( null );
        SteamLabel yourself = new SteamLabel("用户:" + name);
        SteamButton back = new SteamButton("退出");
        SteamButton user = new SteamButton("用户信息");
        SteamButton store = new SteamButton("商店");
        SteamButton storehouse = new SteamButton("库存");
        SteamButton market = new SteamButton("市场");
        yourself.setBounds(800,0,100,20);
        back.setBounds(900,40,100,20);
        user.setBounds(0,0,90,40);
        store.setBounds(90,0,90,40);
        storehouse.setBounds(180,0,90,40);
        market.setBounds(270,0,90,40);
        user.setHorizontalAlignment(SwingConstants.CENTER);
        store.setHorizontalAlignment(SwingConstants.CENTER);
        storehouse.setHorizontalAlignment(SwingConstants.CENTER);
        market.setHorizontalAlignment(SwingConstants.CENTER);
        back.addActionListener(e -> {
            JFrame frame = new LoginFrame("Steam 登录");
            // 关闭窗口时 退出整个程序
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            // 设置窗口大小
            frame.setSize(480,330);
            // 设置居中
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            int x = (int)(toolkit.getScreenSize().getWidth()-frame.getWidth())/2;
            int y = (int)(toolkit.getScreenSize().getHeight()-frame.getHeight())/2;
            frame.setLocation(x, y);
            // 显示窗口
            frame.setVisible(true);
            dispose();
        });
        user.addActionListener(e -> {
            SteamApi.UserRequest(name);
            dispose();
        });
        store.addActionListener(e -> {
            SteamApi.Openstore(name);
            dispose();
        });
        storehouse.addActionListener(e -> {

        });
        market.addActionListener(e -> {

        });
        root.add( yourself );
        root.add( back );
        root.add( user );
        root.add( store );
        root.add( storehouse );
        root.add( market );

    }
}
