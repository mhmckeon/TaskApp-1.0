package com.personalproject.taskapplication;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import connect.DatabaseQueryer;
import taskapplication.src.main.java.com.personalproject.taskapplication.IndividualGoal;


// Need to add deleting goal functionality
// Need to add adding a goal functionality 


public class Main {
    public static void main(String[] args) {
        DatabaseQueryer newDatabase = new DatabaseQueryer();

        Scanner scanner = new Scanner(System.in);
        String inputString= "";
        Integer inputInteger= 0;
        ArrayList<Map<Integer, String>> goalList = newDatabase.getGoalList();
        ArrayList<IndividualGoal> activeGoals = new ArrayList<>();

        
        // used to loop through all active goals
        System.out.println("Goals:");
        for (Map<Integer, String> key : goalList) {
            for (Integer task_id : key.keySet()) {
                String value = key.get(task_id);
                System.out.println("GoalID: "+ task_id + "\tGoalName: "+ value);
            }    
        }
           

        while (!(inputString.equals("quit")) ) {
            System.out.println("Goals:");
            for (Map<Integer, String> key : goalList) {
                for (Integer task_id : key.keySet()) {
                    String value = key.get(task_id);
                    System.out.println("GoalID: "+ task_id + "\tGoalName: "+ value);
                }    
            }

            System.out.println("Start the goal timer: 'S'\tStop the goal timer: 'D'");
            System.out.println("Add a goal: 'add'\tDelete a goal: 'del'\tQuit the program: quit");
            System.out.print("Enter the desired action:");
            inputString = scanner.nextLine();

            if (inputString.equals("S")) {
                System.out.print("Which goal would you like to start?");
                inputInteger = scanner.nextInt();
                for (Map<Integer, String> keyMap : goalList){
                    if (keyMap.containsKey(inputInteger)) {
                        String tempString = keyMap.get(inputInteger);
                        IndividualGoal newGoal = new IndividualGoal(inputInteger, tempString);
                        newGoal.start();
                        activeGoals.add(newGoal);
                        break;
                    }
                } 
            } else if (inputString.equals("D")) {
                System.out.print("Which goal would you like to end?");
                inputInteger = scanner.nextInt();
                for (IndividualGoal individualGoal : activeGoals) {
                    if (individualGoal.getGoalID() == inputInteger){
                        Double finishTime = individualGoal.finish();
                        newDatabase.insertGoalTime(individualGoal.getGoalID(), finishTime);
                        activeGoals.remove(individualGoal);
                        break;
                    }
                }
            } else if (inputString.equals("add")){
                System.out.print("Enter new goal name: ");
                String tempString = scanner.nextLine();
                newDatabase.insertGoal(tempString);
                goalList = newDatabase.getGoalList();
            } else if (inputString.equals("del")) {
                System.out.print("Enter ID of goal to delete: ");
                Integer toDelInteger = scanner.nextInt();
                newDatabase.deleteGoal(toDelInteger);
                goalList = newDatabase.getGoalList();
            }

        }
        System.out.println(activeGoals);
        for (IndividualGoal individualGoal : activeGoals) {
            Double finishTime = individualGoal.finish();
            newDatabase.insertGoalTime(individualGoal.getGoalID(), finishTime);
        }

        newDatabase.closeConnection();
    }
}