package JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestJDBC {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Connection conn = null;
        try {
            //1.数据库连接的4个基本要素
            //①JDBC URL用于标识一个被注册的驱动程序，驱动程序管理器通过这个URL选择正确的驱动程序，从而建立到数据库的连接；
            //jdbc：表示URL中的协议
            //mysql：子协议，用于标识mysql数据库驱动程序
            //localhost:本机的IP地址
            //3306：mysql 默认端口号
            //test：表示访问test数据库
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
            String sql = "select * from user";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //执行语句
            /**/
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            //返回地数据存储在result中

            while (resultSet.next()){

            }
            if (resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
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

}

