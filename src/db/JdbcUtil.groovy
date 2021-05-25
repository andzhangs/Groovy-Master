package db

import groovy.sql.Sql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class JdbcUtil {

    //创建三个常量来存放地址、用户名、和密码   ctrl +shift+x   变为大写
    private static final String URL="jdbc:mysql://localhost:3306/weatherinfo?characterEncoding=utf8&useSSL=false";
    private static final String NAME="root";
    private static final String PASSWORD="admin2020";
    private static final String DRIVER_CLASS="com.mysql.jdbc.Driver"

    public static void main(String[] args) {
        //1.加载驱动程序
        Class.forName(DRIVER_CLASS);
        //2.获取数据库的连接   （数据库的地址、用户名 、密码来连接我们的数据库）
        Connection conn= DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        Statement stmt =conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from weather");
        while(rs.next()) {
            System.out.println(rs.getString("city")+", "+rs.getInt('temperature'))
        }
    }
}
