package taskapplication.src.test.java;

import org.junit.Test;

import taskapplication.src.main.java.com.personalproject.taskapplication.IndividualGoal;

import static org.junit.Assert.*;

public class IndividualGoalTest {

    @Test
    public void addToTotalTimeTest(){
        IndividualGoal newtask = new IndividualGoal("Task 1");
        assertEquals(0, newtask.getTotalTime(), 3000);
    }
    
}
