package steam;

import javax.swing.*;
import java.sql.*;

public class SteamApi {

    public static void UserRequest (String name)
    {
        JFrame userCenterFrame = new UserCenterFrame(name);
        userCenterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userCenterFrame.setResizable(false);
        // 设置窗口大小
        userCenterFrame.setSize(1000,600);
        // 显示窗口
        userCenterFrame.setVisible(true);
    }

    public static boolean loginRequest(String acname, JPasswordField jpw, JCheckBox rem) {
        boolean bool = false;
        Connection conn = null;
        String pw = new String(jpw.getPassword());
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
            String sql = "select * from user where acname = ? and password = ?";
            st = conn.prepareStatement(sql);
            st.setString(1,acname);
            st.setString(2,pw);
            //执行语句
            rs = st.executeQuery();
            if (rs.next())
            {
//                System.out.println("成功");
                String sql2 = "update record set acname = ?, password = ? where id = ?";
                st = conn.prepareStatement(sql2);
                st.setString(3,"1");
                st.setString(1,acname);
                if (rem.isSelected())
                {
                    st.setString(2,pw);
                }
                else
                {
                    st.setString(2,"");
                }
                int n=st.executeUpdate();//这里面不需要参数
                JOptionPane.showMessageDialog(null, "登录成功！", "欢迎登录Steam",JOptionPane.INFORMATION_MESSAGE);
                bool = true;
            }
            else
                JOptionPane.showMessageDialog(null, "账户名称或密码错误", "请重试",JOptionPane.ERROR_MESSAGE);

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
        if (bool) return true;
        else return false;
    }

    public static void exit()
    {
        System.exit(0);
    }

    public static void updatePassword() {
        JFrame help = new HelpFrame("Steam 帮助");
        help.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        help.setResizable(false);
        // 设置窗口大小
        help.setSize(480,330);
        // 显示窗口
        help.setVisible(true);
    }

    public static void registerRequest() {
        JFrame register = new RegisterFrame("Steam 注册");
        register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        register.setResizable(false);
        // 设置窗口大小
        register.setSize(480,330);
        // 显示窗口
        register.setVisible(true);
    }
    public static void steamHelper(JPasswordField passwordField, JTextField textField, SteamLabel wrong) {
        String pw = new String(passwordField.getPassword());
        int text = textField.getText().length();
        String str = textField.getText();
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
            System.out.println(conn);
            //获取statement对象
            /*Statement statement = connection.createStatement();*/
            String sql = "select * from user where key = ?";
            st = conn.prepareStatement(sql);
            st.setString(1,str);
            System.out.println(str);
            rs = st.executeQuery();
            if (rs.next())
            {
                System.out.println("1");
//                namelabel.setText( rs.getString("acname"));
//                String sql1 = "update user set password = ? where key = ?";
//                st = conn.prepareStatement(sql1);
//                st.setString(2,str);
//                st.setString(1,pw);
//                rs = st.executeQuery();
            }
            else wrong.setVisible( true );
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
        if( text == 0 || pwd == 0 )
            wrong.setVisible( true );
        else if( pwd < 8 ) {
            wrong.setVisible( true );
        }
        else
            wrong.setVisible(false);

    }

    public static void Openstore(String name) {
        JFrame ssf = new SteamStoreFrame(name);
        ssf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ssf.setResizable(false);
        // 设置窗口大小
        ssf.setSize(1000,600);
        // 显示窗口
        ssf.setVisible(true);
    }
}
