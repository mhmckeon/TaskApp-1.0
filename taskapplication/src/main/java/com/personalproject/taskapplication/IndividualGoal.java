package com.personalproject.taskapplication;

public class IndividualGoal {
    private String taskName = "";
    private Integer goalID = 0;
    private double totalTime;
    private long startTime;
    private long finishTime;

    public IndividualGoal(Integer tempGoalID, String initialName){
        this.goalID = tempGoalID;
        this.taskName = initialName;
        this.totalTime = 0;
    }

    public Integer getGoalID() {
        return goalID;
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

    public double finish() {
        finishTime = System.nanoTime();
        return ((double)(finishTime - startTime)/1000000000);
    }

    public void addToTotalTime() {
        totalTime += (double)(finishTime - startTime);
    }

    public double getTotalTime() {
        return totalTime;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return (String)(this.goalID + " " + this.taskName);
    }
}