/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookShoping;

import java.sql.*;

public class API {
   
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=BookStore;encrypt=false";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    // Connection object
    private Connection connection;

    // Constructor to establish the connection
    public API(){
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void   Add(String sql) {
    try (Statement statement = connection.createStatement()) {
        int rowsAffected = statement.executeUpdate(sql);
        if (rowsAffected > 0) {
            System.out.println("Record was added successfully. Rows affected: " + rowsAffected);
        } else {
            System.out.println("Failed to insert into the database.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void Delete(String sql) {
    try (Statement statement = connection.createStatement()) {
        int rowsAffected = statement.executeUpdate(sql);
        if (rowsAffected > 0) {
            System.out.println("Delete operation executed successfully. Rows affected: " + rowsAffected);
        } else {
            System.out.println("No rows affected.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Method to execute an SQL update (INSERT, UPDATE, DELETE) statement
  public void Update(String sql) {
    try (Statement statement = connection.createStatement()) {
        int rowsAffected = statement.executeUpdate(sql);
        if (rowsAffected > 0) {
            System.out.println("Update operation executed successfully. Rows affected: " + rowsAffected);
        } else {
            System.out.println("No rows affected.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Method to execute an SQL query (SELECT) statement
   public ResultSet Display(String sql) {
    ResultSet resultSet = null;
    try {
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return resultSet;
}


    // Method to close the database connection
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        API api = new API();
//
//        // Example usage:
//        // Add a record
//        String addRecordSql = "INSERT INTO user_Table (name, surname, email, password) VALUES ('John', 'Doe', 'john.doe@example.com', 'password123')";
//        api.executeUpdate(addRecordSql);
//
//        // Display records
//        String displayRecordsSql = "SELECT * FROM user_Table";
//        api.executeQuery(displayRecordsSql);
//
//        // Update a record
//        String updateRecordSql = "UPDATE user_Table SET email = 'john.doe@newdomain.com' WHERE user_id = 1";
//        api.executeUpdate(updateRecordSql);
//
//        // Delete a record
//        String deleteRecordSql = "DELETE FROM user_Table WHERE user_id = 1";
//        api.executeUpdate(deleteRecordSql);
//
//        // Close the connection
//        api.closeConnection();
//    }
}
