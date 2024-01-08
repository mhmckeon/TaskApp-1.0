package taskapplication.src.main.java.com.personalproject.taskapplication;

public class IndividualGoal {
    private String taskName = "";
    private double totalTime;
    private long startTime;
    private long finishTime;

    // if adding in weekly goals / time stamps - LocalDate might be useful

    public IndividualGoal(String initialName){
        this.taskName = initialName;
        this.totalTime = 0;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }
    
    public void start() {
        startTime = System.nanoTime();
    }

    public void finish() {
        finishTime = System.nanoTime();
    }

    public void addToTotalTime() {
        totalTime += (double)(finishTime - startTime);
    }

    public double getTotalTime() {
        return totalTime;
    }
}