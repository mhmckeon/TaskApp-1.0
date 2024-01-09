package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.sql.Timestamp;
import java.util.Calendar;


import com.personalproject.taskapplication.IndividualGoal;

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
        try (Statement statement = this.conn.createStatement()) {
            String createTasksTable = "CREATE TABLE IF NOT EXISTS task_completions (" +
                    "completion_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "task_id INT,"+
                    "completion_length INT NOT NULL," +
                    "completion_datetime DATETIME NOT NULL,"+
                    "FOREIGN KEY(task_id) REFERENCES tasks(task_id)"+
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

    public void insertGoalTime(Integer task_id, double completion_length){
        
        String sql = "INSERT INTO task_completions(task_id,completion_length, completion_datetime) VALUES (?,?,?)";

        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)){
            pstmt.setInt(1, task_id);
            pstmt.setDouble(2, completion_length);

            Timestamp currenTimestamp = new Timestamp(System.currentTimeMillis());
            pstmt.setTimestamp(3, currenTimestamp);
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

    public ArrayList<Map<Integer,String>> getGoalList(){
        String sql = "SELECT task_id, task_name FROM tasks";
        ArrayList<Map<Integer, String>> goalList = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int taskID = rs.getInt("task_id");
                String taskName = rs.getString("task_name");

                Map<Integer,String> goalMap = new HashMap<>();
                goalMap.put(taskID,taskName);
                goalList.add(goalMap);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return goalList;

    }


    public static void main(String[] args) {
        DatabaseQueryer newDatabase = new DatabaseQueryer();
        newDatabase.insertGoal("finishProject");
        newDatabase.getGoalList();
        newDatabase.deleteGoal(1);
        newDatabase.insertGoalTime(2,23);
        newDatabase.closeConnection();

    }
}
    
