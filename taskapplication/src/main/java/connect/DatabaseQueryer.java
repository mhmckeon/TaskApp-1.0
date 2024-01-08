package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DatabaseQueryer {
    private Connection conn;

    public DatabaseQueryer() {
        try {
            String url = "jdbc:sqlite:C:/Users/micha/OneDrive/Projects/TaskApp-1.0/taskapplication/src/main/resources/db/goals";
            this.conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (Statement statement = this.conn.createStatement()) {
            String createTasksTable = "CREATE TABLE IF NOT EXISTS tasks (" +
                    "task_id INT PRIMARY KEY," +
                    "task_name VARCHAR(255) NOT NULL" +
                    ");";
            statement.executeUpdate(createTasksTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertGoal(String goalNameString){
        String sql = "INSERT INTO tasks(task_id, task_name) VALUES (?,?)";


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
    
