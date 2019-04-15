package okkpp.code.gen.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbKit {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static Connection connection = null;
    private String url;

    static {
//        Properties properties = new Properties();
//        properties.setProperty("user", "root");
//        properties.setProperty("password", "123456");
    }

    public void init(){
        this.url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(url, "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public List<Colunm> showColumns(String table) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("show columns from "+table);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Colunm> result = new ArrayList<Colunm>();
        while(resultSet.next()){
            boolean nullable = resultSet.getString(3).equals("YES");
            boolean isPriKey = resultSet.getString(4).equals("PRI");
            Colunm colunm = new Colunm(resultSet.getString(1), resultSet.getString(2), nullable, isPriKey);
            result.add(colunm);
        }
        return result;
    }
    public static void main(String[] args) throws SQLException {
        DbKit db = new DbKit();
        db.init();
        List<Colunm> list = db.showColumns("yx_edu_study");
        System.out.println(list);
    }
}
