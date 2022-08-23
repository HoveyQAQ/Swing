package steam;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public LoginFrame(String title)
    {
        super(title);
        JPanel root = new JPanel();
        root.setBackground(new Color(42, 45, 50));
        this.setLocationRelativeTo(null);
        this.setContentPane( root );
        // 不使用布局器
        root.setLayout( null );
        // 设置Steam图标
        PictureView icon = new PictureView();
        icon.setBorder(BorderFactory.createLineBorder(new Color(42, 45, 50)));
        icon.setImage("/res/img1.png");
        // 手工指定位置
        icon.setBounds(70,40,149,49);
        // Label
        SteamLabel acname = new SteamLabel("账户名称");
        SteamLabel password = new SteamLabel("密码");
        SteamLabel help = new SteamLabel("登陆时需要帮助吗?");
        SteamLabel registerAction = new SteamLabel("还没有Steam账户?");
        acname.setBounds(60,112,84,11);
        password.setBounds(60,142,84,11);
        help.setBounds(70,224,140,11);
        registerAction.setBounds(70,254,140,11);
        // 文本 Filed
        SteamTextField textField = new SteamTextField();
        SteamPasswordField passwordField = new SteamPasswordField();
        // Button
        SteamButton login = new SteamButton("登录");
        SteamButton cancel = new SteamButton("取消");
        SteamButton helpButton = new SteamButton("我无法登录...");
        SteamButton register = new SteamButton("创建一个新的账户...");
        login.setBounds(150,180,128,20);
        cancel.setBounds(284,180,128,20);
        helpButton.setBounds(220,220,192,20);
        register.setBounds(220,250,192,20);
        // 复选框
        JCheckBox remember = new JCheckBox("记住我的密码",false);
        remember.setBounds(150,164,260,14);
        remember.setFont(Font.getFont("等线"));
        remember.setForeground(Color.GRAY);
        remember.setBackground(new Color(42, 45, 50));
        // 事件处理
            // 登录
        login.addActionListener(e -> {
            if (SteamApi.loginRequest(textField.getText(),passwordField,remember))
            {
                SteamApi.UserRequest(textField.getText());
                dispose();
            }
        });
            // 取消登录
        cancel.addActionListener(e -> {
            SteamApi.exit();
        });
            // 帮助
        helpButton.addActionListener(e -> {
            SteamApi.updatePassword();
            dispose();
        });
            // 注册
        register.addActionListener(e -> {
            SteamApi.registerRequest();
            dispose();
        });

        // 组件添加
        root.add( icon );

        root.add( remember );

        root.add( login );
        root.add( cancel );
        root.add( helpButton );
        root.add( register );

        root.add( acname );
        root.add( password );
        root.add( help );
        root.add( registerAction );

        root.add( textField );
        root.add( passwordField );
    }


}
