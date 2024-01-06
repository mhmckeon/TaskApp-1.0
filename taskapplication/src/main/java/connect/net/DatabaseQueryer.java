package taskapplication.src.main.java.connect.net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class DatabaseQueryer {
     /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            // C:\Users\micha\OneDrive\Projects\TaskApp-1.0\taskapplication\src\main\resources\db
            String url = "jdbc:sqlite:C:/Users/micha/OneDrive/Projects/TaskApp-1.0/taskapplication/src/main/resources/db/goals";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void createDatabase(){
        try (Statement statement = connection.createStatement()) {
            String createTasksTable = "CREATE TABLE tasks (" +
                    "task_id INT PRIMARY KEY," +
                    "task_name VARCHAR(255) NOT NULL" +
                    ");";
            statement.executeUpdate(createTasksTable);
        }

        try (Statement statement = connection.createStatement()) {
            String createTaskCompletionsTable = "CREATE TABLE task_completions (" +
                    "completion_id INT PRIMARY KEY," +
                    "task_id INT," +
                    "completion_datetime DATETIME NOT NULL," +
                    "FOREIGN KEY (task_id) REFERENCES tasks(task_id)" +
                    ");";
            statement.executeUpdate(createTaskCompletionsTable);
        
        System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
        createDatabase();
    }
