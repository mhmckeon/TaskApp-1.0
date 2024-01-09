package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
                    "task_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "task_name VARCHAR(255) NOT NULL" +
                    ");";
            statement.executeUpdate(createTasksTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertGoal(String goalNameString){
        String sql = "INSERT INTO tasks(task_name) VALUES (?)";
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)){
            pstmt.setString(1, goalNameString);
            pstmt.executeUpdate();
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }    

    public void deleteGoal(int ID) {
        String sql = "DELETE FROM tasks WHERE task_id = ?";
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)){
            pstmt.setInt(1, ID);
            pstmt.executeUpdate();
            
        } catch (SQLException e){
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
        newDatabase.insertGoal("finishProject");
        newDatabase.deleteGoal(1);
        newDatabase.closeConnection();

    }
}
    
