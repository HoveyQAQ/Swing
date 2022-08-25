package steam;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class UserCenterFrame extends UserFrame{

    public UserCenterFrame(String name) {
        super(name);
        this.setTitle("个人中心");
        root.setLayout(null);
        // Picture
        Random r = new Random();
        int index = r.nextInt(5)+1;
        PictureView pictureAvatar = new PictureView();
        switch (index) {
            case 1:pictureAvatar.setImage("/res/1.jpg");
                break;
            case 2:pictureAvatar.setImage("/res/2.jpg");
                break;
            case 3:pictureAvatar.setImage("/res/3.png");
                break;
            case 4:pictureAvatar.setImage("/res/4.png");
                break;
            case 5:pictureAvatar.setImage("/res/5.png");
                break;
            default:
                break;
        }

        pictureAvatar.setBounds(130,60,100,100);
        // Label
        SteamLabel avatar = new SteamLabel("头像");
        SteamLabel accountName = new SteamLabel("账户名");
        SteamLabel password = new SteamLabel("密码");
        SteamLabel cancellation = new SteamLabel("请确认是否注销账号");
        avatar.setBounds(20,100,50,30);
        accountName.setBounds(20,190,50,30);
        password.setBounds(20,250,50,30);
        cancellation.setBounds(20,310,200,30);
        // Field
        UserTextField accountNameField = new UserTextField();
        UserTextField passwordField = new UserTextField();
        accountNameField.setText(name);
        accountNameField.setBounds(90,196,200,20);
        passwordField.setBounds(90,256,200,20);
        // Button
        SteamButton uAB = new SteamButton("换一个");
        UserNameButton uNB = new UserNameButton("更改账户名");
        UserPasswordButton uPB = new UserPasswordButton("更改密码");
        UserCancellationButton uCB = new UserCancellationButton("注销账号");
        uAB.setBounds(320,106,100,20);
        uNB.setBounds(320,196,100,20);
        uPB.setBounds(320,256,100,20);
        uCB.setBounds(320,316,100,20);
        uAB.addActionListener(e -> {
            SteamApi.userRequest(name);
            dispose();
        });
        uNB.addActionListener(e -> {
            String str = null;
            if ("0" != (str = SteamApi.updateUserName(name, accountNameField.getText())))
            {
                JFrame userCenterFrame = new UserCenterFrame(str);
                userCenterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                userCenterFrame.setResizable(false);
                // 设置窗口大小
                userCenterFrame.setSize(1000,600);
                // 显示窗口
                userCenterFrame.setVisible(true);
                dispose();
            }

        });
        uPB.addActionListener(e -> {

            String str = null;
            if ("0" != (str = SteamApi.updateUserPassword(name,passwordField.getText())))
            {
                JFrame userCenterFrame = new UserCenterFrame(str);
                userCenterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                userCenterFrame.setResizable(false);
                // 设置窗口大小
                userCenterFrame.setSize(1000,600);
                // 设置居中
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                int x = (int)(toolkit.getScreenSize().getWidth()-userCenterFrame.getWidth())/2;
                int y = (int)(toolkit.getScreenSize().getHeight()-userCenterFrame.getHeight())/2;
                userCenterFrame.setLocation(x, y);
                // 显示窗口
                userCenterFrame.setVisible(true);
                dispose();
            }
        });
        uCB.addActionListener(e -> {
            if (SteamApi.deleteUser(name))
            {
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
            }
        });
        // 添加
        root.add( pictureAvatar );
        root.add( avatar );
        root.add( accountName );
        root.add( password );
        root.add( cancellation );
        root.add( accountNameField );
        root.add( passwordField );
        root.add( uAB );
        root.add( uNB );
        root.add( uPB );
        root.add( uCB );


    }
}
