package taskapplication.src.main.java.com.personalproject.taskapplication;
public class Application {
    public static void main(String[] args){
        IndividualGoal newTask = new IndividualGoal("Task 1");
        newTask.start();
        newTask.finish();
        newTask.addToTotalTime();
        
        System.out.println(newTask.getTaskName());
        System.out.println(newTask.getTotalTime());
    } 
}
