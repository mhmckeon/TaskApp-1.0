public class Application {
    public static void main(String[] args){
        Task newTask = new Task("Task 1");
        newTask.start();
        newTask.finish();
        newTask.addToTotalTime();
        
        System.out.println(newTask.getName());
        System.out.println(newTask.getTotalTime());
    } 
}
