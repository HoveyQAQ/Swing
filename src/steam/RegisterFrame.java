package steam;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Random;

public class RegisterFrame extends JFrame {
    JTextField textField = new JTextField();
    SteamLabel keywordlabel = new SteamLabel("");
    JPasswordField passwordField = new JPasswordField();
    SteamButton register = new SteamButton("注册");
    SteamButton back = new SteamButton("返回");
    SteamLabel wrong = new SteamLabel("注册要求：用户名小于20个字符，密码大于8个字符！");
    public RegisterFrame(String title)
    {
        super(title);
        JPanel root = new JPanel();
        root.setBackground(new Color(42, 45, 50));
        this.setContentPane( root );
        this.setLocationRelativeTo(null);
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
        SteamLabel keyword = new SteamLabel("找回码");

        acname.setBounds(60,112,84,11);
        password.setBounds(60,142,84,11);
        keyword.setBounds(200,10,60,11);
        keywordlabel.setBounds(270,10,60,11);
        wrong.setBounds(120,170,300,11);
        wrong.setVisible(false);

        // 文本 Filed
        textField.setBounds(150,110,260,20);
        passwordField.setBounds(150,140,260,20);
        // Button
        register.setBounds(150,200,128,20);
        back.setBounds(284,200,128,20);
        register.addActionListener(e -> {
            steamRegister();
        });
        back.addActionListener(e -> {
            JFrame frame = new LoginFrame("Steam 登录");
            // 关闭窗口时 退出整个程序
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            // 设置窗口大小
            frame.setSize(480,330);
            // 显示窗口
            frame.setVisible(true);
            dispose();
        });

        // 组件添加
        root.add( icon );
        root.add( register );
        root.add(back);
        root.add( acname );
        root.add( password );
        root.add( keyword );
        root.add( keywordlabel );
        root.add( textField );
        root.add( passwordField );
        root.add( wrong );
    }
    public static String createRandomStr1(){
        int length = 5;
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            stringBuffer.append(str.charAt(number));
        }
        return stringBuffer.toString();
    }

    public String getKey() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String str = createRandomStr1();
        try {
            String url = "jdbc:mysql://localhost:3306/steam";
            //user:登录数据库的用户名
            String user = "root"; //自己的账号
            //password:用户名对应的密码，这些都是自己之前设定的
            String password = "zhyzhyzh2003"; //自己的密码
            //mySql的驱动：com.mysql.jdbc.Driver
            String driverName = "com.mysql.jdbc.Driver";
            //2.实例化Driver
            Class clazz = Class.forName(driverName);
            Driver driver = (Driver) clazz.newInstance();
            //3.通过DriverManager来注册驱动
            DriverManager.registerDriver(driver);
            //4.通过DriverManager的getConnection方法，获取Connection类的对象
            conn = DriverManager.getConnection(url, user, password);
            //5.打印出conn对象
//            System.out.println(conn);
            //获取statement对象
            /*Statement statement = connection.createStatement();*/
            String sql = "select * from user where key = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, str);
            rs = st.executeQuery();
            if (rs.next()) {
                getKey();
            } else {
                return str;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                //当conn不为空时
                if (conn != null)
                    //关闭conn资源
                    conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        keywordlabel.setText(str);
        return str;
    }


    public void steamRegister(){
        String pw = new String(passwordField.getPassword());
        int text = textField.getText().length();
        int pwd = pw.length();
        if( text == 0 || pwd == 0 )
            wrong.setVisible( true );
        else if( text > 20 || pwd < 8 ) {
            wrong.setVisible( true );
        }
        else
            wrong.setVisible(false);
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String url = "jdbc:mysql://localhost:3306/steam";
            //user:登录数据库的用户名
            String user = "root"; //自己的账号
            //password:用户名对应的密码，这些都是自己之前设定的
            String password = "zhyzhyzh2003"; //自己的密码
            //mySql的驱动：com.mysql.jdbc.Driver
            String driverName = "com.mysql.jdbc.Driver";
            //2.实例化Driver
            Class clazz = Class.forName(driverName);
            Driver driver = (Driver) clazz.newInstance();
            //3.通过DriverManager来注册驱动
            DriverManager.registerDriver(driver);
            //4.通过DriverManager的getConnection方法，获取Connection类的对象
            conn = DriverManager.getConnection(url, user, password);
            //5.打印出conn对象
            System.out.println(conn);
            //获取statement对象
            /*Statement statement = connection.createStatement();*/
            String sql = "insert into user values (?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1,textField.getText());
            st.setString(2,pw);
            st.setString(3,getKey());
            int count=st.executeUpdate();//返回增加的记录条数
//            if (count > 0)
//                System.out.println("成功");
//            else System.out.println("失败");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                //当conn不为空时
                if(conn != null)
                    //关闭conn资源
                    conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
