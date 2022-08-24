package steam;

import javax.swing.*;

public class SteamStoreFrame extends UserFrame {

    public SteamStoreFrame(String name) {
        super(name);


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

        //按钮
        JButton CSbuy = new BuyButton();
        CSbuy.setBounds(39,155,50,30);
        JButton CSsell = new SellButton();
        CSsell.setBounds(105,155,50,30);
        JButton Pbuy = new BuyButton();
        Pbuy.setBounds(173,155,50,30);
        JButton Psell = new SellButton();
        Psell.setBounds(239,155,50,30);
        JButton Abuy = new BuyButton();
        Abuy.setBounds(303,155,50,30);
        JButton Asell = new SellButton();
        Asell.setBounds(369,155,50,30);
        JButton Ebuy = new BuyButton();
        Ebuy.setBounds(438,155,50,30);
        JButton Esell = new SellButton();
        Esell.setBounds(504,155,50,30);
        JButton Nbuy = new BuyButton();
        Nbuy.setBounds(573,155,50,30);
        JButton Nsell = new SellButton();
        Nsell.setBounds(639,155,50,30);
        JButton Fbuy = new BuyButton();
        Fbuy.setBounds(707,155,50,30);
        JButton Fsell = new SellButton();
        Fsell.setBounds(773,155,50,30);
        JButton Hbuy = new BuyButton();
        Hbuy.setBounds(39,292,50,30);
        JButton Hsell = new SellButton();
        Hsell.setBounds(105,292,50,30);
        JButton HMbuy =new BuyButton();
        HMbuy.setBounds(172,292,50,30);
        JButton HMsell = new SellButton();
        HMsell.setBounds(238,292,50,30);
        JButton ARKbuy = new BuyButton();
        ARKbuy.setBounds(306,292,50,30);
        JButton ARKsell = new SellButton();
        ARKsell.setBounds(372,292,50,30);
        JButton NBAbuy = new BuyButton();
        NBAbuy.setBounds(440,292,50,30);
        JButton NBAsell = new SellButton();
        NBAsell.setBounds(506,292,50,30);
        JButton Obuy =new BuyButton();
        Obuy.setBounds(574,292,50,30);
        JButton Osell = new SellButton();
        Osell.setBounds(640,292,50,30);


        //控件添加
        root.add( CSbuy );
        root.add( CSsell );
        root.add( Pbuy );
        root.add( Psell );
        root.add( Abuy );
        root.add( Asell );
        root.add( Ebuy );
        root.add( Esell );
        root.add( Nbuy );
        root.add( Nsell );
        root.add( Fbuy );
        root.add( Fsell );
        root.add( Hbuy );
        root.add( Hsell );
        root.add( HMbuy );
        root.add( HMsell );
        root.add( ARKbuy );
        root.add( ARKsell );
        root.add( NBAbuy );
        root.add( NBAsell );
        root.add( Obuy );
        root.add( Osell );
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

