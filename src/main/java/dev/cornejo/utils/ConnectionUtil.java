package dev.cornejo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection createConnection(){

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://cornejo-sql-server.postgres.database.azure.com:5432/librarydb?user=cornejoAdmin&password=Bman1215}&ssl=false");
            return conn;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}