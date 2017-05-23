package com.codecool.shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class controls the connection to the database
 * based on login data stored in connection.properties.
 */

public class DbConnection {

    /**
     * This method reads the login data from the file and creates variables with the proper values
     * @return DriverManager.getConnection object with login data
     * @throws IOException throws when file not found
     * @throws SQLException throws when connection can't be returned
     */
    public Connection getConnection() throws IOException, SQLException {

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/connection.properties"));
        final String DATABASE = "jdbc:postgresql://" + br.readLine() + "/" + br.readLine();
        final String DB_USER = br.readLine();
        final String DB_PASSWORD = br.readLine();
        br.close();

        return DriverManager.getConnection(
                DATABASE,
                DB_USER,
                DB_PASSWORD);
    }

    /**
     * Tries to execute query which is stored in a string.
     * @param query string that contains the query
     */
    public void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
        ){
            statement.execute(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}