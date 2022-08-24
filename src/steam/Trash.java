package steam;

import javax.swing.*;
import java.sql.*;

public class Trash {
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
}
