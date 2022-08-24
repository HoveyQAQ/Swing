package steam;

import javax.swing.*;

public class SteamStoreFrame extends UserFrame {

    public SteamStoreFrame(String name) {
        super(name);
        this.setTitle("Steam 商店");
        //图片
        PictureView icon = new PictureView();
        icon.setImage("/res/cs.png");
        icon.setBounds(39,93,119,46);
        PictureView PUBG = new PictureView();
        PUBG.setImage("/res/PUBG.png");
        PUBG.setBounds(173,93,119,46);
        PictureView APEX = new PictureView();
        APEX.setImage("/res/APEX.png");
        APEX.setBounds(303,93,119,46);
        PictureView ER = new PictureView();
        ER.setImage("/res/ER.png");
        ER.setBounds(438,93,119,46);
        PictureView NRK = new PictureView();
        NRK.setImage("/res/NARAKA.png");
        NRK.setBounds(573,93,119,46);
        PictureView FH5 = new PictureView();
        FH5.setImage("/res/FH5.png");
        FH5.setBounds(707,93,119,46);
        PictureView HFF = new PictureView();
        HFF.setImage("/res/HFF.png");
        HFF.setBounds(39,230,119,46);
        PictureView HM3 = new PictureView();
        HM3.setImage("/res/HM3.png");
        HM3.setBounds(172,230,119,46);
        PictureView ARK = new PictureView();
        ARK.setImage("/res/ARK.png");
        ARK.setBounds(306,230,119,46);
        PictureView NBA = new PictureView();
        NBA.setImage("/res/2K22.png");
        NBA.setBounds(440,230,119,46);
        PictureView OC2 = new PictureView();
        OC2.setImage("/res/OC2.png");
        OC2.setBounds(574,230,119,46);
        PictureView weixin = new PictureView();
        weixin.setImage("/res/weixin.png");
        weixin.setBounds(50,400,100,100);

        PictureView zfb = new PictureView();
        zfb.setImage("/res/zfb.png");
        zfb.setBounds(250,400,100,100);
        //按钮
        JButton CSbuy = new BuyButton();
        CSbuy.setBounds(39,155,119,40);
        JButton Pbuy = new BuyButton();
        Pbuy.setBounds(173,155,119,40);
        JButton Abuy = new BuyButton();
        Abuy.setBounds(303,155,119,40);
        JButton Ebuy = new BuyButton();
        Ebuy.setBounds(438,155,119,40);
        JButton Nbuy = new BuyButton();
        Nbuy.setBounds(573,155,119,40);
        JButton Fbuy = new BuyButton();
        Fbuy.setBounds(707,155,119,40);
        JButton Hbuy = new BuyButton();
        Hbuy.setBounds(39,292,119,40);
        JButton HMbuy =new BuyButton();
        HMbuy.setBounds(172,292,119,40);
        JButton ARKbuy = new BuyButton();
        ARKbuy.setBounds(306,292,119,40);
        JButton NBAbuy = new BuyButton();
        NBAbuy.setBounds(440,292,119,40);
        JButton Obuy =new BuyButton();
        Obuy.setBounds(574,292,119,40);

        // 监听
        CSbuy.addActionListener(e -> {
            SteamApi.deductBalance(98,name,"CSGO");
            dispose();
            SteamApi.openStore(name);
        });
        Pbuy.addActionListener(e -> {
            SteamApi.deductBalance(98,name,"PUBG");
            dispose();
            SteamApi.openStore(name);
        });
        Abuy.addActionListener(e -> {
            SteamApi.deductBalance(98,name,"APEX");
            dispose();
            SteamApi.openStore(name);
        });
        Ebuy.addActionListener(e -> {
            SteamApi.deductBalance(98,name,"EldenRing");
            dispose();
            SteamApi.openStore(name);
        });
        Nbuy.addActionListener(e -> {
            SteamApi.deductBalance(98,name,"Nakara");
            dispose();
            SteamApi.openStore(name);
        });
        Fbuy.addActionListener(e -> {
            SteamApi.deductBalance(98,name,"Horizon5");
            dispose();
            SteamApi.openStore(name);
        });
        Hbuy.addActionListener(e -> {
            SteamApi.deductBalance(98,name,"HumanFallFlat");
            dispose();
            SteamApi.openStore(name);
        });
        HMbuy.addActionListener(e -> {
            SteamApi.deductBalance(98,name,"HITMAN");
            dispose();
            SteamApi.openStore(name);
        });
        ARKbuy.addActionListener(e -> {
            SteamApi.deductBalance(98,name,"ARK");
            dispose();
            SteamApi.openStore(name);
        });
        NBAbuy.addActionListener(e -> {
            SteamApi.deductBalance(98,name,"NBA2K2022");
            dispose();
            SteamApi.openStore(name);
        });
        Obuy.addActionListener(e -> {
            SteamApi.deductBalance(98,name,"Overcooked");
            dispose();
            SteamApi.openStore(name);
        });
        // Label
        SteamLabel Attention = new SteamLabel("<===左侧扫码充值余额");
        Attention.setBounds(200,400,300,100);
        //控件添加
        root.add( weixin );
        root.add( zfb );
        root.add( Attention );
        root.add( CSbuy );
        root.add( Pbuy );
        root.add( Abuy );
        root.add( Ebuy );
        root.add( Nbuy );
        root.add( Fbuy );
        root.add( Hbuy );
        root.add( HMbuy );
        root.add( ARKbuy );
        root.add( NBAbuy );
        root.add( Obuy );
        root.add( icon );
        root.add( PUBG );
        root.add( APEX );
        root.add( ER );
        root.add( NRK );
        root.add( FH5 );
        root.add( HFF );
        root.add( HM3 );
        root.add( ARK );
        root.add( NBA );
        root.add( OC2 );
   }
}

