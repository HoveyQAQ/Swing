package steam;

import javax.swing.*;

public class SteamMarketFrame extends UserFrame{

    public SteamMarketFrame(String name) {
        super(name);
        this.setTitle("Steam 市场");
        root.setLayout(null);
        // Picture
        PictureView Recoil = new PictureView();
        Recoil.setImage("/res/Recoil.png");
        Recoil.setBounds(0,80,200,200);

        PictureView Nightmares = new PictureView();
        Nightmares.setImage("/res/Nightmares.png");
        Nightmares.setBounds(200,80,200,200);

        PictureView Clutch = new PictureView();
        Clutch.setImage("/res/Clutch.png");
        Clutch.setBounds(400,80,200,200);

        PictureView Gamma = new PictureView();
        Gamma.setImage("/res/Gamma.png");
        Gamma.setBounds(600,80,200,200);

        PictureView Cobble = new PictureView();
        Cobble.setImage("/res/Cobble.png");
        Cobble.setBounds(800,80,200,200);

        PictureView weixin = new PictureView();
        weixin.setImage("/res/weixin.png");
        weixin.setBounds(50,400,100,100);

        PictureView zfb = new PictureView();
        zfb.setImage("/res/zfb.png");
        zfb.setBounds(250,400,100,100);
        // Label
        SteamLabel RecoilLabel = new SteamLabel("反冲武器箱 ￥:16");
        SteamLabel NightmaresLabel = new SteamLabel("梦魇武器箱 ￥:16");
        SteamLabel ClutchLabel = new SteamLabel("命悬武器箱 ￥:16");
        SteamLabel GammaLabel = new SteamLabel("伽马武器箱 ￥:16");
        SteamLabel CobbleLabel = new SteamLabel("古堡激战纪念包 ￥:4000");
        SteamLabel Attention = new SteamLabel("<===左侧扫码充值余额");
        Attention.setBounds(200,400,300,100);

        RecoilLabel.setBounds(0,280,200,20);
        RecoilLabel.setHorizontalAlignment(SwingConstants.CENTER);

        NightmaresLabel.setBounds(200,280,200,20);
        NightmaresLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ClutchLabel.setBounds(400,280,200,20);
        ClutchLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GammaLabel.setBounds(600,280,200,20);
        GammaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        CobbleLabel.setBounds(800,280,200,20);
        CobbleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // button
        MarketBuy RecoilButton = new MarketBuy();
        MarketBuy NightmaresButton = new MarketBuy();
        MarketBuy ClutchButton = new MarketBuy();
        MarketBuy GammaButton = new MarketBuy();
        MarketBuy CobbleButton = new MarketBuy();
        CobbleButton.setText("开启纪念包");
        RecoilButton.setBounds(30,320,140,40);
        RecoilButton.setHorizontalAlignment(SwingConstants.CENTER);

        NightmaresButton.setBounds(230,320,140,40);
        NightmaresButton.setHorizontalAlignment(SwingConstants.CENTER);

        ClutchButton.setBounds(430,320,140,40);
        ClutchButton.setHorizontalAlignment(SwingConstants.CENTER);

        GammaButton.setBounds(630,320,140,40);
        GammaButton.setHorizontalAlignment(SwingConstants.CENTER);

        CobbleButton.setBounds(830,320,140,40);
        CobbleButton.setHorizontalAlignment(SwingConstants.CENTER);
        // 监听
        RecoilButton.addActionListener(e -> {
            SteamApi.openCase("Recoil",name);
            dispose();
            SteamApi.openMarket(name);
        });
        NightmaresButton.addActionListener(e -> {
            SteamApi.openCase("Nightmares",name);
            dispose();
            SteamApi.openMarket(name);
        });
        ClutchButton.addActionListener(e -> {
            SteamApi.openCase("Clutch",name);
            dispose();
            SteamApi.openMarket(name);
        });
        GammaButton.addActionListener(e -> {
            SteamApi.openCase("Gamma",name);
            dispose();
            SteamApi.openMarket(name);
        });
        CobbleButton.addActionListener(e -> {
            SteamApi.openCase("Cobble",name);
            dispose();
            SteamApi.openMarket(name);
        });
        // add
        root.add( Recoil );
        root.add( Nightmares );
        root.add( Clutch );
        root.add( Gamma );
        root.add( Cobble );
        root.add( weixin );
        root.add( zfb );

        root.add( Attention );
        root.add( RecoilLabel );
        root.add( NightmaresLabel );
        root.add( ClutchLabel );
        root.add( GammaLabel );
        root.add( CobbleLabel );

        root.add( RecoilButton );
        root.add( NightmaresButton );
        root.add( ClutchButton );
        root.add( GammaButton );
        root.add( CobbleButton );

    }
}
