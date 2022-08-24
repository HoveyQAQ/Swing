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
        root.setLayout( null );
        SteamLabel rights = new SteamLabel("© Copyright 2022. Powered by HoveyQAQTeam. All rights reserved.");
        rights.setBounds(0,540,1000,15);
        rights.setHorizontalAlignment(SwingConstants.CENTER);
        rights.setFont(new Font("微软雅黑",Font.BOLD,10));
        root.add( rights );
        SteamLabel yourself = new SteamLabel("用户:" + name);
        SteamLabel balance = new SteamLabel("余额:" + SteamApi.getUserBalance( name ));
        SteamButton back = new SteamButton("退出");
        SteamButton user = new SteamButton("用户信息");
        SteamButton store = new SteamButton("商店");
        SteamButton storehouse = new SteamButton("库存");
        SteamButton market = new SteamButton("市场");
        SteamButton snake = new SteamButton("贪吃蛇 免费开玩!");

        yourself.setHorizontalAlignment(SwingConstants.LEFT);
        balance.setHorizontalAlignment(SwingConstants.LEFT);
        yourself.setBounds(820,0,100,22);
        balance.setBounds(820,23,100,22);
        back.setBounds(900,50,100,20);

        user.setBounds(0,0,90,40);
        store.setBounds(90,0,90,40);
        storehouse.setBounds(180,0,90,40);
        market.setBounds(270,0,90,40);
        snake.setBounds(360,0,150,40);
        user.setHorizontalAlignment(SwingConstants.CENTER);
        store.setHorizontalAlignment(SwingConstants.CENTER);
        storehouse.setHorizontalAlignment(SwingConstants.CENTER);
        market.setHorizontalAlignment(SwingConstants.CENTER);
        snake.setHorizontalAlignment(SwingConstants.CENTER);
        back.setHorizontalAlignment(SwingConstants.CENTER);

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
            SteamApi.userRequest(name);
            dispose();
        });
        store.addActionListener(e -> {
            SteamApi.openStore(name);
            dispose();
        });
        storehouse.addActionListener(e -> {
            SteamApi.openStoreHouse(name);

        });
        market.addActionListener(e -> {
            SteamApi.openMarket(name);
            dispose();
        });
        snake.addActionListener(e -> {
            JFrame snakeGame = new MainFrame();
            snakeGame.setTitle("Steam 贪吃蛇");
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            int x = (int)(toolkit.getScreenSize().getWidth()-snakeGame.getWidth())/2;
            int y = (int)(toolkit.getScreenSize().getHeight()-snakeGame.getHeight())/2;
            snakeGame.setLocation(x, y);
            snakeGame.setVisible(true);
        });
        root.add( yourself );
        root.add( balance );
        root.add( back );
        root.add( user );
        root.add( store );
        root.add( storehouse );
        root.add( market );
        root.add( snake );

    }
}
