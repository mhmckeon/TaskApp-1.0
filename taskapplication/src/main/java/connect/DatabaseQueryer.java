package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseQueryer {
    private Connection conn;

    public DatabaseQueryer() {
        try {
            String url = "jdbc:sqlite:C:/Users/micha/OneDrive/Projects/TaskApp-1.0/taskapplication/src/main/resources/db/goals";
            this.conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    

    public void closeConnection(){
        try {
            conn.close();
            System.out.println("Connection closed.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        DatabaseQueryer newDatabase = new DatabaseQueryer();
        newDatabase.closeConnection();
    }
}
    
