package com.vedha.collections.jdbc;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;

public class JDBC {

    public static void main(String[] args) throws SQLException, FileNotFoundException {

        System.out.println("Specified driver object found in classpath: " + DriverManager.getDriver("jdbc:h2:mem:db;MODE=Oracle;AUTO_RECONNECT=TRUE"));
//        System.out.println(DriverManager.getDriver("jdbc:oracle:thin:@//myoracle.db.server:1521/my_servicename"));
//        System.out.println(DriverManager.getDriver("jdbc:mysql://mysql.db.server:3306/my_database?useSSL=false&serverTimezone=UTC"));
//        System.out.println(DriverManager.getDriver("jdbc:sqlserver://mssql.db.server\\mssql_instance;databaseName=my_database"));
//        System.out.println(DriverManager.getDriver("jdbc:postgresql://postgresql.db.server:5430/my_database?ssl=true&loglevel=2"));
        System.out.println("--------------------------------------");

        System.out.println("available driver objects found in classpath: ");
        DriverManager.drivers().forEach(System.out::println);
        System.out.println("--------------------------------------");

        // Normal Java JDBCConnection
//        DriverManager.setLogWriter(new PrintWriter("D:\\jdbc.log"));
//        DriverManager.setLogWriter(new PrintWriter(System.out));
//        DriverManager.registerDriver(DriverManager.getDriver("jdbc:h2:mem:db"));
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:db", "test", "test");
        System.out.println("Connection Object: " + connection);

        // Spring JDBC Connection
        Connection connection1 = new DriverManagerDataSource("jdbc:h2:mem:db", "test", "test").getConnection();

        // Create Table
        boolean execute = connection.createStatement().execute("""
                create table test (
                        id bigint not null,
                        name varchar(255),
                        primary key (id)
                    )""");
        System.out.println("Create Table: " + execute);

        // Insert
        PreparedStatement preparedStatement = connection1.prepareStatement("insert into test (id, name) values (?, ?)");
        preparedStatement.setQueryTimeout(1); // Query Timeout in Seconds
        preparedStatement.setInt(1, 1);
        preparedStatement.setString(2, "Master");
        int i = preparedStatement.executeUpdate();
        System.out.println("Inserted Record: " + i);

        // Query
        Statement statement = connection1.createStatement();
        statement.setQueryTimeout(1); // Query Timeout in Seconds
        statement.setFetchSize(5); // Fetching 5 and next 5 rows
        ResultSet resultSet = statement.executeQuery("select id, name from test");
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("id") + ", " + "Name: " + resultSet.getString("name"));
        }

        connection.close();
        connection1.close();
    }
}
