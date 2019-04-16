package okkpp.code.gen.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbKit {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static Connection connection = null;
    private static DbKit singleton = null;
    public static DbKit me(){
        if(null==singleton){
            singleton = new DbKit();
        }
        return singleton;
    }
    public DbKit(){
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(System.getProperty("jdbc.url"),
                    System.getProperty("jdbc.username"),
                    System.getProperty("jdbc.password"));
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
        PreparedStatement statement = connection.prepareStatement("show full columns from "+table);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Colunm> result = new ArrayList<Colunm>();
        while(resultSet.next()){
            boolean nullable = resultSet.getString("Null").equals("YES");
            boolean isPriKey = resultSet.getString("Key").equals("PRI");
            Colunm colunm = new Colunm(resultSet.getString("Field"), resultSet.getString("Type"), resultSet.getString("Comment"), nullable, isPriKey);
            result.add(colunm);
        }
        return result;
    }
}
