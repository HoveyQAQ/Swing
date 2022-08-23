package steam;

import javax.swing.*;
import java.sql.*;

public class SteamPasswordField extends JPasswordField {
    public SteamPasswordField ()
    {
        this.setBounds(150,140,260,20);
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
            String sql = "select * from record where id = ?";
            st = conn.prepareStatement(sql);
            st.setString(1,"1");
            rs = st.executeQuery();
            if (rs.next())
                this.setText( rs.getString("password"));
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
