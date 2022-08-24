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
        // Label
        SteamLabel RecoilLabel = new SteamLabel("反冲武器箱 ￥:16");
        SteamLabel NightmaresLabel = new SteamLabel("梦魇武器箱 ￥:16");
        SteamLabel ClutchLabel = new SteamLabel("命悬武器箱 ￥:16");
        SteamLabel GammaLabel = new SteamLabel("伽马武器箱 ￥:16");
        SteamLabel CobbleLabel = new SteamLabel("古堡激战纪念包 ￥:4000");
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

        // add
        root.add( Recoil );
        root.add( Nightmares );
        root.add( Clutch );
        root.add( Gamma );
        root.add( Cobble );

        root.add( RecoilLabel );
        root.add( NightmaresLabel );
        root.add( ClutchLabel );
        root.add( GammaLabel );
        root.add( CobbleLabel );

    }
}
