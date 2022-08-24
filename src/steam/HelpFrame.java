package steam;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class HelpFrame extends JFrame {
    JTextField keyFiled = new JTextField();
    SteamLabel nameLabel = new SteamLabel("");
    JPasswordField passwordField = new JPasswordField();
    SteamButton sure = new SteamButton("确定");
    SteamButton back = new SteamButton("返回");
    SteamLabel wrong = new SteamLabel("找回码错误或密码格式不正确！");
    public HelpFrame(String title)
    {
        super(title);
        JPanel root = new JPanel();
        root.setBackground(new Color(42, 45, 50));
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
        SteamLabel acname = new SteamLabel("找回码");
        SteamLabel password = new SteamLabel("密码");
        SteamLabel keyword = new SteamLabel("账户名称");

        acname.setBounds(60,112,84,11);
        password.setBounds(60,142,84,11);
        keyword.setBounds(200,10,60,11);
        nameLabel.setBounds(270,10,60,11);
        wrong.setBounds(120,170,300,11);
        wrong.setVisible(false);

        // 文本 Filed
        keyFiled.setBounds(150,110,260,20);
        passwordField.setBounds(150,140,260,20);
        // Button
        sure.setBounds(150,200,128,20);
        back.setBounds(284,200,128,20);
        sure.addActionListener(e -> {
            if (steamHelper())
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
        back.addActionListener(e -> {
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
        });

        // 组件添加
        root.add( icon );
        root.add( sure );
        root.add( back );
        root.add( acname );
        root.add( password );
//        root.add( keyword );
//        root.add( nameLabel );
        root.add( keyFiled );
        root.add( passwordField );
        root.add( wrong );
    }

    public String getName() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String str = keyFiled.getText();
        try {
            String url = "jdbc:mysql://47.96.86.184:3306/steam";
            //user:登录数据库的用户名
            String user = "HoveyQAQ"; //自己的账号
            //password:用户名对应的密码，这些都是自己之前设定的
            String password = "Zhyzhyzh2003!"; //自己的密码
            //mySql的驱动：com.mysql.jdbc.Driver
            String driverName = "com.mysql.cj.jdbc.Driver";
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
            String sql = "select * from user where IDkey = ?";
//            System.out.println(str);
            st = conn.prepareStatement(sql);
            st.setString(1, str);
            rs = st.executeQuery();
            if (rs.next()) {
                String sql2 = "update record set acname = ? where id = ?";
                st = conn.prepareStatement(sql2);
                st.setString(2,"1");
                st.setString(1, rs.getString( "acname" ));
                int n=st.executeUpdate();//这里面不需要参数
                JOptionPane.showMessageDialog(null, "找回成功！您的账户是" +rs.getString( "acname" ), "欢迎回到Steam",JOptionPane.INFORMATION_MESSAGE);
            }
            else return "0";
            str = rs.getString( "acname");
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
        return str;
    }
    public boolean steamHelper(){
        String str = keyFiled.getText();
        String pw = new String(passwordField.getPassword());
        int text = keyFiled.getText().length();
        int pwd = pw.length();

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String url = "jdbc:mysql://47.96.86.184:3306/steam";
            //user:登录数据库的用户名
            String user = "HoveyQAQ"; //自己的账号
            //password:用户名对应的密码，这些都是自己之前设定的
            String password = "Zhyzhyzh2003!"; //自己的密码
            //mySql的驱动：com.mysql.jdbc.Driver
            String driverName = "com.mysql.cj.jdbc.Driver";
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
            if (getName() == "0") {
                wrong.setVisible(true);
                return false;
            }
            String sql = "update user set password = ? where IDkey = ?";
            st = conn.prepareStatement(sql);
            st.setString(2, str);
            st.setString(1, pw);
            int n=st.executeUpdate();//这里面不需要参数


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
        if( text == 0 || pwd == 0 ) {
            wrong.setVisible(true);
            return false;
        }
        else if( text > 20 || pwd < 8 ) {
            wrong.setVisible( true );
            return false;
        }
        else
        {
            wrong.setVisible(false);
            return true;
        }
    }
}
