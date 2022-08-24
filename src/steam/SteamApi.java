package steam;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SteamApi {
    public static void OpenMarket(String name) {
        SteamMarketFrame steamMarketFrame = new SteamMarketFrame(name);
        steamMarketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        steamMarketFrame.setResizable(false);
        // 设置窗口大小
        steamMarketFrame.setSize(1000,600);
        // 设置居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int x = (int)(toolkit.getScreenSize().getWidth()-steamMarketFrame.getWidth())/2;
        int y = (int)(toolkit.getScreenSize().getHeight()-steamMarketFrame.getHeight())/2;
        steamMarketFrame.setLocation(x, y);
        // 显示窗口
        steamMarketFrame.setVisible(true);
    }
    public static void OpenStoreHouse(String name) {
        
    }
    public static void UserRequest (String name)
    {
        JFrame userCenterFrame = new UserCenterFrame(name);
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
        // 设置居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int x = (int)(toolkit.getScreenSize().getWidth()-help.getWidth())/2;
        int y = (int)(toolkit.getScreenSize().getHeight()-help.getHeight())/2;
        help.setLocation(x, y);
        // 显示窗口
        help.setVisible(true);
    }

    public static void registerRequest() {
        JFrame register = new RegisterFrame("Steam 注册");
        register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        register.setResizable(false);
        // 设置窗口大小
        register.setSize(480,330);
        // 设置居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int x = (int)(toolkit.getScreenSize().getWidth()-register.getWidth())/2;
        int y = (int)(toolkit.getScreenSize().getHeight()-register.getHeight())/2;
        register.setLocation(x, y);
        // 显示窗口
        register.setVisible(true);
    }

    public static void OpenStore(String name) {
        JFrame ssf = new SteamStoreFrame(name);
        ssf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ssf.setResizable(false);
        // 设置窗口大小
        ssf.setSize(1000,600);
        // 设置居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int x = (int)(toolkit.getScreenSize().getWidth()-ssf.getWidth())/2;
        int y = (int)(toolkit.getScreenSize().getHeight()-ssf.getHeight())/2;
        ssf.setLocation(x, y);
        // 显示窗口
        ssf.setVisible(true);
    }
    public static String updateUserName(String name, String text) {
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
            String sql = "select * from user where acname = ?";
            st = conn.prepareStatement(sql);
            st.setString(1,name);
            //执行语句
            rs = st.executeQuery();
            if (rs.next())
            {
                String key = rs.getNString( "IDkey" );
                String sql2 = "update user set acname = ? where IDkey = ?";
                st = conn.prepareStatement(sql2);
                st.setString(2,key);
                st.setString(1,text);
                int n=st.executeUpdate();//这里面不需要参数
                String sql3 = "update record set acname = ? where id = ?";
                PreparedStatement st1 = conn.prepareStatement(sql3);
                st1.setString(2,"1");
                st1.setString(1,text);
                int n1=st1.executeUpdate();//这里面不需要参数
                return text;
            }
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
        return "0";
    }
    public static String updateUserPassword(String name, String text) {
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
            String sql = "select * from user where acname = ?";
            st = conn.prepareStatement(sql);
            st.setString(1,name);
            //执行语句
            rs = st.executeQuery();
            if (rs.next())
            {
                String key = rs.getNString( "IDkey" );
                String sql2 = "update user set password = ? where IDkey = ?";
                st = conn.prepareStatement(sql2);
                st.setString(2,key);
                st.setString(1,text);
                int n=st.executeUpdate();//这里面不需要参数
                String sql3 = "update record set password = ? where id = ?";
                PreparedStatement st1 = conn.prepareStatement(sql3);
                st1.setString(2,"1");
                st1.setString(1,"");
                int n1=st1.executeUpdate();//这里面不需要参数
                return name;
            }
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
        return "0";
    }


    public static boolean deleteUser(String name) {
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
            String sql = "delete from user where acname = ?";
            st = conn.prepareStatement(sql);
            st.setString(1,name);
            //执行语句
            int n=st.executeUpdate();//这里面不需要参数
            if (n > 0)
            {
                String sql3 = "update record set acname = ? , password = ? where id = ?";
                PreparedStatement st1 = conn.prepareStatement(sql3);
                st1.setString(3,"1");
                st1.setString(1,"");
                st1.setString(2,"");
                int n1=st1.executeUpdate();//这里面不需要参数
                return true;
            }
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
        return false;
    }

    public static String getUserBalance(String name) {
        String str = null;
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
            String sql = "select * from user where acname = ?";
            st = conn.prepareStatement(sql);
            st.setString(1,name);
            //执行语句
            rs = st.executeQuery();
            rs.next();
            str = (String) rs.getString("balance");
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
        return str;
    }
}
