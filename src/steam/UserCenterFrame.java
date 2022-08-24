package steam;

import javax.swing.*;

public class UserCenterFrame extends UserFrame{

    public UserCenterFrame(String name) {
        super(name);
        this.setTitle("个人中心");
        root.setLayout(null);
        // Label
        SteamLabel accountName = new SteamLabel("账户名");
        SteamLabel password = new SteamLabel("密码");
        SteamLabel cancellation = new SteamLabel("请确认是否注销账号");
        accountName.setBounds(20,90,50,30);
        password.setBounds(20,150,50,30);
        cancellation.setBounds(20,210,200,30);
        // Field
        UserTextField accountNameField = new UserTextField();
        UserTextField passwordField = new UserTextField();
        accountNameField.setText(name);
        accountNameField.setBounds(90,96,200,20);
        passwordField.setBounds(90,156,200,20);
        // Button
        UserNameButton uNB = new UserNameButton("更改账户名");
        UserPasswordButton uPB = new UserPasswordButton("更改密码");
        UserCancellationButton uCB = new UserCancellationButton("注销账号");
        uNB.setBounds(320,96,100,20);
        uPB.setBounds(320,156,100,20);
        uCB.setBounds(320,216,100,20);
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
                // 显示窗口
                userCenterFrame.setVisible(true);
                dispose();
            }
        });
        // 添加
        root.add( accountName );
        root.add( password );
        root.add( cancellation );
        root.add( accountNameField );
        root.add( passwordField );
        root.add( uNB );
        root.add( uPB );
        root.add( uCB );


    }
}