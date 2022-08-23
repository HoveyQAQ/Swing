package steam;

import javax.swing.*;
import java.awt.*;

public class UserFrame extends JFrame {
    public UserFrame (String name)
    {
        super( "个人中心" );
        JPanel root = new JPanel();
        root.setBackground(new Color(42, 45, 50));
        this.setContentPane( root );
        this.setLocationRelativeTo(null);
        root.setLayout( null );
        SteamLabel yourself = new SteamLabel("用户:" + name);
        SteamButton user = new SteamButton("用户信息");
        SteamButton store = new SteamButton("商店");
        SteamButton storehouse = new SteamButton("库存");
        SteamButton market = new SteamButton("市场");
        yourself.setBounds(800,0,100,20);
        user.setBounds(0,0,90,40);
        store.setBounds(90,0,90,40);
        storehouse.setBounds(180,0,90,40);
        market.setBounds(270,0,90,40);
        user.setHorizontalAlignment(SwingConstants.CENTER);
        store.setHorizontalAlignment(SwingConstants.CENTER);
        storehouse.setHorizontalAlignment(SwingConstants.CENTER);
        market.setHorizontalAlignment(SwingConstants.CENTER);
        user.addActionListener(e -> {

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
        root.add( user );
        root.add( store );
        root.add( storehouse );
        root.add( market );

    }
}
