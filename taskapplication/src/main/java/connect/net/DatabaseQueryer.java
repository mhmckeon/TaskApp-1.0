package taskapplication.src.main.java.connect.net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryer {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/taskapplication/src/main/java/connect/net/goalsdatabase";
            // create a connection to the database

            // try {
            //     Class.forName("org.sqlite.JDBC");
            //  }
            //  catch(ClassNotFoundException ex) {
            //     System.out.println("Error: unable to load driver class!");
            //     System.exit(1);
            //  }

            connection = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");

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
            }

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
}
