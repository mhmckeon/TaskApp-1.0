public class Task {
    private String taskName = "";
    private double totalTime;
    private long startTime;
    private long finishTime;

    // if adding in weekly goals / time stamps - LocalDate might be useful

    public Task(String initialName){
        this.taskName = initialName;
        this.totalTime = 0;
    }

    public void setName(String name) {
        taskName = name;
    }

    public String getName(){
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