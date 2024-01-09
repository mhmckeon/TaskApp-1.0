import java.util.HashMap;
import java.util.Map;

public class GoalStorage {
    private Map<Integer, String> goalsMap = new HashMap<>();

    public void addGoal(int id, String name) {
        goalsMap.put(id, name);
    }

    public String getGoalName(int id) {
        return goalsMap.get(id);
    }

    // Other methods...
}
