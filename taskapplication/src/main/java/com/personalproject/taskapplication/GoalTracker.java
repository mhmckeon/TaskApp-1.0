package taskapplication.src.main.java.com.personalproject.taskapplication;

import java.util.ArrayList;

public class GoalTracker {
    private ArrayList<IndividualGoal> listOfIndividualGoals;

    public GoalTracker(){
        this.listOfIndividualGoals = new ArrayList<IndividualGoal>();
    }

    public ArrayList<IndividualGoal> getListOfIndividualGoals(){
        return listOfIndividualGoals;
    }

    public void addGoal(IndividualGoal goalName){
        this.listOfIndividualGoals.add(goalName);
    }

    public void deleteGoal(IndividualGoal goalName){
        this.listOfIndividualGoals.remove(goalName);
    }
}
