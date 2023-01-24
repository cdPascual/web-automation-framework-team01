package utilities;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import jdk.jshell.execution.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ConnectDB {
    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;
    public static Connection connectToSqlDatabases(){
        String driverClass = Utility.getProperties().getProperty("MYSQLJDBC.driver");
        String url = Utility.getProperties().getProperty("MYSQLJDBC.url");
        String userName = Utility.getProperties().getProperty("MYSQLJDBC.userName");
        String password = Utility.getProperties().getProperty("MYSQLJDBC.password");
        try{
            Class.forName(driverClass);
            connect = DriverManager.getConnection(url, userName, password);
        }catch(SQLException |ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        System.out.println("Database is connected");
        return connect;
    }
    public static MongoDatabase mongoDatabase =null;
    public MongoDatabase mongoDatabase(){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        mongoDatabase = mongoClient.getDatabase("credentials");
        System.out.println("Database Connected");
        return mongoDatabase;
    }
    public static List<String> getTableColumnData(String query, String columnName){
        List<String> list = new ArrayList<>();
        try {
            statement = connectToSqlDatabases().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                list.add(resultSet.getString(columnName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;
    }
    public static void main(String[] args) throws SQLException {
        List<String> emails = getTableColumnData("select * from credentials", "email");
        System.out.println(emails.get(0));
    }
}
