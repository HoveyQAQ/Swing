package steam;

public class UserCenterFrame extends UserFrame{

    public UserCenterFrame(String name) {
        super(name);
        this.setTitle("个人中心");
        root.setLayout(null);
        // Label
        SteamLabel accountName = new SteamLabel("账户名");
        SteamLabel password = new SteamLabel("密码");
        accountName.setBounds(20,90,50,30);
        password.setBounds(20,150,50,30);
        // Field
        UserTextField accountNameField = new UserTextField();
        UserTextField passwordField = new UserTextField();
        accountNameField.setText(name);
        accountNameField.setBounds(90,96,200,20);
        passwordField.setBounds(90,156,200,20);
        // Button
        UserNameButton uNB = new UserNameButton("更改账户名");


        // 添加
        root.add( accountName );
        root.add( password );
        root.add( accountNameField );
        root.add( passwordField );


    }
}
