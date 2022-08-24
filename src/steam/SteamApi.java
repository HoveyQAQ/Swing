package steam;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Random;

public class SteamApi {
    public static void openMarket(String name) {
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
    public static void openStoreHouse(String name) {
        JFrame storeHouseFrame = new JFrame(name);
        SteamButton back = new SteamButton("退出");
        back.setBounds(900,500,100,20);
        back.setHorizontalAlignment(SwingConstants.CENTER);
        SteamLabel rights = new SteamLabel("© Copyright 2022. Powered by HoveyQAQTeam. All rights reserved.");
        rights.setBounds(0,540,1000,15);
        rights.setHorizontalAlignment(SwingConstants.CENTER);
        rights.setFont(new Font("微软雅黑",Font.BOLD,10));
        storeHouseFrame.add( rights );
        String[] columnNames = { "库存名", "数量" };// 定义表格列名数组
        String[][] rowData = new String[100][2];// 定义表格数据数组
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
                String sql1 = "select * from storehouse where IDkey = ?";
                st = conn.prepareStatement(sql1);
                st.setString(1,key);
                //执行语句
                rs = st.executeQuery();
                rs.next();
                ResultSetMetaData metaData = rs.getMetaData();
                String[] strings = new String[] {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
                String[] set = new String[] {"CSGO", "EldenRing", "Naraka", "NBA2K2022", "APEX", "HITMAN", "PUBG", "HumanFallFlat", "ARK", "Overcooked", "Horizon5", "法玛斯|喵喵36", "M4A4|透明弹匣", "R8左轮手枪|疯狂老八", "SG553|青龙", "截短霰弹枪|么么", "PP-野牛|太空猫", "USP消音版|印花集", "AK-47|夜愿", "双持贝瑞塔|瓜瓜", "USP消音版|地狱门票", "MP5-SD|小小噩梦", "FN57|涂鸦潦草", "SG553|阿罗哈", "MP9|黑砂", "格洛克18型|城里的月光", "MAG-7|SWAG-7", "USP消音版|脑洞大开", "M4A4|黑色魅影", "SCAR-20|血腥运动", "M4A1消音型|机械工业", "截短霰弹枪|聚光灯", "AWP|火卫一", "Tec-9|冰冠", "新星|Exo", "P90|暴风呼啸", "SCAR-20|暴风呼啸", "双持贝瑞塔|蔷薇", "MAC-10|紫青之色", "UMP-45|紫青之色", "MAG-7|银质", "新星|绿苹果", "截短霰弹枪|外表生锈", "USP消音版|宝蓝之色", "P2000|坚固链甲", "MP9|黑暗时代", "CZ75|复古圣杯", "沙漠之鹰|手上加农炮", "M4A1消音型|骑士", "AWP|巨龙传说"
                };
                for (int i = 2, j = 2; j <= 50;j ++)
                {
                    if (rs.getInt(j) > 0)
                    {
                        int count = rs.getInt(j);
//                        rowData[i-2][0] = metaData.getColumnClassName(i);
                        rowData[i-2][0] = set[j-2];
                        rowData[i-2][1] = strings[count];
                        i ++;
                    }
                }

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

        JTable table = new JTable(rowData, columnNames);// 创建指定列名和数据的表格
        JScrollPane scrollPane = new JScrollPane(table);// 创建显示表格的滚动面板
        Container c = storeHouseFrame.getContentPane();
        c.add(scrollPane, BorderLayout.CENTER);
        storeHouseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        storeHouseFrame.setResizable(false);
        // 设置窗口大小
        storeHouseFrame.setSize(1000,600);
        // 设置居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int x = (int)(toolkit.getScreenSize().getWidth()-storeHouseFrame.getWidth())/2;
        int y = (int)(toolkit.getScreenSize().getHeight()-storeHouseFrame.getHeight())/2;
        storeHouseFrame.setLocation(x, y);
        // 显示窗口
        storeHouseFrame.setVisible(true);
    }
    public static void userRequest(String name)
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

    public static void openStore(String name) {
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
            String sql = "select * from user where acname = ?";
//            System.out.println(str);
            st = conn.prepareStatement(sql);
            st.setString(1, name);
            rs = st.executeQuery();
            rs.next();
            String key = rs.getString("IDkey");
            String sql2 = "delete from user where acname = ?";
            st = conn.prepareStatement(sql2);
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
                String sql1 = "delete from storehouse where IDkey = ?";
                st = conn.prepareStatement(sql1);
                st.setString(1,key);
                //执行语句
                n=st.executeUpdate();//这里面不需要参数
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

    public static void openCase(String kind, String name) {
        int v = 16;
        int randomKey = new Random().nextInt(65);
        int randomKey1 = new Random().nextInt(1099);
        String [] RecoilSet = new String[]{"法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","法玛斯 | 喵喵36","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","M4A4 | 透明弹匣","R8 左轮手枪 | 疯狂老八","R8 左轮手枪 | 疯狂老八","R8 左轮手枪 | 疯狂老八","R8 左轮手枪 | 疯狂老八","R8 左轮手枪 | 疯狂老八","R8 左轮手枪 | 疯狂老八","R8 左轮手枪 | 疯狂老八","R8 左轮手枪 | 疯狂老八","R8 左轮手枪 | 疯狂老八","R8 左轮手枪 | 疯狂老八","SG 553 | 青龙","SG 553 | 青龙","SG 553 | 青龙","SG 553 | 青龙","SG 553 | 青龙","SG 553 | 青龙","SG 553 | 青龙","SG 553 | 青龙","SG 553 | 青龙","SG 553 | 青龙","截短霰弹枪 | 么么","截短霰弹枪 | 么么","截短霰弹枪 | 么么","截短霰弹枪 | 么么","USP 消音版 | 印花集"};
        String [] NightmaresSet = new String[]{"FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","FN57 | 涂鸦潦草","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","MP5-SD | 小小噩梦","PP-野牛 | 太空猫","PP-野牛 | 太空猫","PP-野牛 | 太空猫","PP-野牛 | 太空猫","PP-野牛 | 太空猫","PP-野牛 | 太空猫","PP-野牛 | 太空猫","PP-野牛 | 太空猫","PP-野牛 | 太空猫","PP-野牛 | 太空猫","USP 消音版 | 地狱门票","USP 消音版 | 地狱门票","USP 消音版 | 地狱门票","USP 消音版 | 地狱门票","USP 消音版 | 地狱门票","USP 消音版 | 地狱门票","USP 消音版 | 地狱门票","USP 消音版 | 地狱门票","USP 消音版 | 地狱门票","USP 消音版 | 地狱门票","双持贝瑞塔 | 瓜瓜","双持贝瑞塔 | 瓜瓜","双持贝瑞塔 | 瓜瓜","双持贝瑞塔 | 瓜瓜","AK-47 | 夜愿"};
        String [] ClutchSet = new String[]{"SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","SG 553 | 阿罗哈","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","MP9 | 黑砂","格洛克 18 型 | 城里的月光","格洛克 18 型 | 城里的月光","格洛克 18 型 | 城里的月光","格洛克 18 型 | 城里的月光","格洛克 18 型 | 城里的月光","格洛克 18 型 | 城里的月光","格洛克 18 型 | 城里的月光","格洛克 18 型 | 城里的月光","格洛克 18 型 | 城里的月光","MAG-7 | SWAG-7","MAG-7 | SWAG-7","MAG-7 | SWAG-7","MAG-7 | SWAG-7","MAG-7 | SWAG-7","MAG-7 | SWAG-7","MAG-7 | SWAG-7","MAG-7 | SWAG-7","MAG-7 | SWAG-7","MAG-7 | SWAG-7","USP 消音版 | 脑洞大开","USP 消音版 | 脑洞大开","USP 消音版 | 脑洞大开","USP 消音版 | 脑洞大开","M4A4 | 黑色魅影"};
        String [] GammaSet = new String[]{"新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","新星 | Exo","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","Tec-9 | 冰冠","AWP | 火卫一","AWP | 火卫一","AWP | 火卫一","AWP | 火卫一","AWP | 火卫一","AWP | 火卫一","AWP | 火卫一","AWP | 火卫一","AWP | 火卫一","AWP | 火卫一","截短霰弹枪 | 聚光灯","截短霰弹枪 | 聚光灯","截短霰弹枪 | 聚光灯","截短霰弹枪 | 聚光灯","截短霰弹枪 | 聚光灯","截短霰弹枪 | 聚光灯","截短霰弹枪 | 聚光灯","截短霰弹枪 | 聚光灯","截短霰弹枪 | 聚光灯","截短霰弹枪 | 聚光灯","SCAR-20 | 血腥运动","SCAR-20 | 血腥运动","SCAR-20 | 血腥运动","SCAR-20 | 血腥运动","M4A1 消音型 | 机械工业"};
        String [] CobbleSet = new String[]{"P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","M4A1 消音型 | 骑士","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","M4A1 消音型 | 骑士", "P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","M4A1 消音型 | 骑士", "P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","AWP | 巨龙传说","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","M4A1 消音型 | 骑士", "P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","M4A1 消音型 | 骑士", "P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","P90 | 暴风呼啸","SCAR-20 | 暴风呼啸","双持贝瑞塔 | 蔷薇","MAC-10 | 紫青之色","UMP-45 | 紫青之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","MAG-7 | 银质","新星 | 绿苹果","截短霰弹枪 | 外表生锈","USP 消音版 | 宝蓝之色","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","P2000 | 坚固链甲","MP9 | 黑暗时代","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","CZ75 | 复古圣杯","沙漠之鹰 | 手上加农炮","M4A1 消音型 | 骑士",
        };
        String Item = null;
        switch (kind) {
            case "Recoil":
                SteamApi.addStoreHouse(name,RecoilSet[randomKey]);
                JOptionPane.showMessageDialog(null, "恭喜您获得" + RecoilSet[randomKey],"反冲武器箱" ,JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Nightmares":
                SteamApi.addStoreHouse(name,NightmaresSet[randomKey]);
                JOptionPane.showMessageDialog(null, "恭喜您获得" + NightmaresSet[randomKey], "梦魇武器箱",JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Clutch":
                SteamApi.addStoreHouse(name,ClutchSet[randomKey]);
                JOptionPane.showMessageDialog(null, "恭喜您获得" + ClutchSet[randomKey], "命悬武器箱",JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Gamma":
                SteamApi.addStoreHouse(name,GammaSet[randomKey]);
                JOptionPane.showMessageDialog(null, "恭喜您获得" + GammaSet[randomKey], "伽马武器箱",JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Cobble":
                SteamApi.addStoreHouse(name,CobbleSet[randomKey1]);
                v = 4000;
                JOptionPane.showMessageDialog(null, "恭喜您获得" + CobbleSet[randomKey1], "古堡激战纪念包",JOptionPane.INFORMATION_MESSAGE);
                break;
            default: break;
        }
        SteamApi.deductBalance(v,name);

    }

    private static void deductBalance(int value, String name) {
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
            int p =  rs.getInt("balance");
            String sql2 = "update user set balance = ? where acname = ?";
            st = conn.prepareStatement(sql2);
            st.setString(2,name);
            if (p - value > 0) {
                st.setInt(1, p - value);
            }
            else
                JOptionPane.showMessageDialog(null, "余额不足！！", "请扫描充值余额",JOptionPane.ERROR_MESSAGE);
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
    }

    public static void addStoreHouse(String name, String Item) {
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
            String keyword = rs.getString("IDkey");

                switch (Item){
                    case "CSGO":
                        String sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        int values = rs.getInt("CSGO");
                        String sql2 = "update storehouse set CSGO = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        int n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "Naraka":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("Naraka");
                        sql2 = "update storehouse set Naraka = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "NBA2K2022":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("NBA2K2022");
                        sql2 = "update storehouse set NBA2K2022 = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "APEX":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("APEX");
                        sql2 = "update storehouse set APEX = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "HITMAN":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("HITMAN");
                        sql2 = "update storehouse set HITMAN = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "PUBG":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("PUBG");
                        sql2 = "update storehouse set PUBG = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;case "HumanFallFlat":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("HumanFallFlat");
                        sql2 = "update storehouse set HumanFallFlat = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "ARK":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("ARK");
                        sql2 = "update storehouse set ARK = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "Overcooked":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("Overcooked");
                        sql2 = "update storehouse set Overcooked = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "HORIZON5":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("HORIZON5");
                        sql2 = "update storehouse set HORIZON5 = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "M4A4 | 透明弹匣":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("M4A4 | 透明弹匣");
                        sql2 = "update storehouse set `M4A4 | 透明弹匣` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "R8 左轮手枪 | 疯狂老八":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("R8 左轮手枪 | 疯狂老八");
                        sql2 = "update storehouse set `R8 左轮手枪 | 疯狂老八` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "SG 553 | 青龙":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("SG 553 | 青龙");
                        sql2 = "update storehouse set `SG 553 | 青龙` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "截短霰弹枪 | 么么":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("截短霰弹枪 | 么么");
                        sql2 = "update storehouse set `截短霰弹枪 | 么么` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "PP-野牛 | 太空猫":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("PP-野牛 | 太空猫");
                        sql2 = "update storehouse set `PP-野牛 | 太空猫` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "USP 消音版 | 印花集":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("USP 消音版 | 印花集");
                        sql2 = "update storehouse set `USP 消音版 | 印花集` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "AK-47 | 夜愿":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("AK-47 | 夜愿");
                        sql2 = "update storehouse set `AK-47 | 夜愿` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "双持贝瑞塔 | 瓜瓜":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("双持贝瑞塔 | 瓜瓜");
                        sql2 = "update storehouse set `双持贝瑞塔 | 瓜瓜` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "USP 消音版 | 地狱门票":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("USP 消音版 | 地狱门票");
                        sql2 = "update storehouse set `USP 消音版 | 地狱门票` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "MP5-SD | 小小噩梦":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("MP5-SD | 小小噩梦");
                        sql2 = "update storehouse set `MP5-SD | 小小噩梦` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "FN57 | 涂鸦潦草":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("FN57 | 涂鸦潦草");
                        sql2 = "update storehouse set `FN57 | 涂鸦潦草` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "SG 553 | 阿罗哈":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("SG 553 | 阿罗哈");
                        sql2 = "update storehouse set `SG 553 | 阿罗哈` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "MP9 | 黑砂":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("MP9 | 黑砂");
                        sql2 = "update storehouse set `MP9 | 黑砂` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "法玛斯 | 喵喵36":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("法玛斯 | 喵喵36");
                        sql2 = "update storehouse set `法玛斯 | 喵喵36` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "格洛克 18 型 | 城里的月光":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("格洛克 18 型 | 城里的月光");
                        sql2 = "update storehouse set `格洛克 18 型 | 城里的月光` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "MAG-7 | SWAG-7":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("MAG-7 | SWAG-7");
                        sql2 = "update storehouse set `MAG-7 | SWAG-7` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "USP 消音版 | 脑洞大开":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("USP 消音版 | 脑洞大开");
                        sql2 = "update storehouse set `USP 消音版 | 脑洞大开` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "M4A4 | 黑色魅影":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("M4A4 | 黑色魅影");
                        sql2 = "update storehouse set `M4A4 | 黑色魅影` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "SCAR-20 | 血腥运动":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("SCAR-20 | 血腥运动");
                        sql2 = "update storehouse set `SCAR-20 | 血腥运动` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "M4A1 消音型 | 机械工业":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("M4A1 消音型 | 机械工业");
                        sql2 = "update storehouse set `M4A1 消音型 | 机械工业` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "截短霰弹枪 | 聚光灯":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("截短霰弹枪 | 聚光灯");
                        sql2 = "update storehouse set `截短霰弹枪 | 聚光灯` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "AWP | 火卫一":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("AWP | 火卫一");
                        sql2 = "update storehouse set `AWP | 火卫一` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "Tec-9 | 冰冠":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("Tec-9 | 冰冠");
                        sql2 = "update storehouse set `Tec-9 | 冰冠` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "新星 | Exo":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("新星 | Exo");
                        sql2 = "update storehouse set `新星 | Exo` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "P90 | 暴风呼啸":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("P90 | 暴风呼啸");
                        sql2 = "update storehouse set `P90 | 暴风呼啸` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "SCAR-20 | 暴风呼啸":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("SCAR-20 | 暴风呼啸");
                        sql2 = "update storehouse set `SCAR-20 | 暴风呼啸` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "双持贝瑞塔 | 蔷薇":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("双持贝瑞塔 | 蔷薇");
                        sql2 = "update storehouse set `双持贝瑞塔 | 蔷薇 喵喵36` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "MAC-10 | 紫青之色":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("MAC-10 | 紫青之色");
                        sql2 = "update storehouse set `MAC-10 | 紫青之色` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "UMP-45 | 紫青之色":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("UMP-45 | 紫青之色");
                        sql2 = "update storehouse set `UMP-45 | 紫青之色` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "MAG-7 | 银质":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("MAG-7 | 银质");
                        sql2 = "update storehouse set `MAG-7 | 银质` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "新星 | 绿苹果":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("新星 | 绿苹果");
                        sql2 = "update storehouse set `新星 | 绿苹果` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "截短霰弹枪 | 外表生锈":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("截短霰弹枪 | 外表生锈");
                        sql2 = "update storehouse set `截短霰弹枪 | 外表生锈` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "USP 消音版 | 宝蓝之色":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("USP 消音版 | 宝蓝之色");
                        sql2 = "update storehouse set `USP 消音版 | 宝蓝之色` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "P2000 | 坚固链甲":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("P2000 | 坚固链甲");
                        sql2 = "update storehouse set `P2000 | 坚固链甲` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "MP9 | 黑暗时代":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("MP9 | 黑暗时代");
                        sql2 = "update storehouse set `MP9 | 黑暗时代` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "CZ75 | 复古圣杯":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("CZ75 | 复古圣杯");
                        sql2 = "update storehouse set `CZ75 | 复古圣杯` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "沙漠之鹰 | 手上加农炮":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("沙漠之鹰 | 手上加农炮");
                        sql2 = "update storehouse set `沙漠之鹰 | 手上加农炮` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "M4A1 消音型 | 骑士":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("M4A1 消音型 | 骑士");
                        sql2 = "update storehouse set `M4A1 消音型 | 骑士` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
                    case "AWP | 巨龙传说":
                        sql1 = "select * from storehouse where IDkey = ?";
                        st = conn.prepareStatement(sql1);
                        st.setString(1,keyword);
                        //执行语句
                        rs = st.executeQuery();
                        rs.next();
                        values = rs.getInt("AWP | 巨龙传说");
                        sql2 = "update storehouse set `AWP | 巨龙传说` = ? where IDkey = ?";
                        st = conn.prepareStatement(sql2);
                        st.setString(2,keyword);
                        st.setInt(1,values+1);
                        n=st.executeUpdate();//这里面不需要参数
                        break;
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
    }

    public static void deductBalance(int value, String name, String Item) {
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
            int p =  rs.getInt("balance");
            String sql2 = "update user set balance = ? where acname = ?";
            st = conn.prepareStatement(sql2);
            st.setString(2,name);
            if (p - value > 0) {
                st.setInt(1, p - value);
                SteamApi.addStoreHouse(name,Item);
            }
            else
                JOptionPane.showMessageDialog(null, "余额不足！！", "请扫描充值余额",JOptionPane.ERROR_MESSAGE);
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
    }

}
