import model.DrinkingGoal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

// Unit tests for TodayDrinkingGoalTest class
public class DrinkingGoalTest {
    private DrinkingGoal goal;
    private int CHANGE_VALUE = 1;
    private int INITIAL_VALUE = 500;

    @BeforeEach
    public void runBefore(){
        goal = new DrinkingGoal(INITIAL_VALUE);
    }

    @Test
    public void testTodayDrinkingGoal() {
        assertEquals(500, goal.getGoal());
    }

    @Test
    public void testAddGoalOnce() {
        goal.addValue(CHANGE_VALUE);
        assertEquals(INITIAL_VALUE + CHANGE_VALUE, goal.getGoal());
    }

    @Test
    public void testAddGoalMultiple() {
        goal.addValue(CHANGE_VALUE);
        goal.addValue(CHANGE_VALUE);
        assertEquals(INITIAL_VALUE + CHANGE_VALUE * 2, goal.getGoal());
    }

    @Test
    public void testSubGoalSmall() {
        goal.subValue(CHANGE_VALUE);
        assertEquals(INITIAL_VALUE - CHANGE_VALUE, goal.getGoal());
    }

    @Test
    public void testSubGoalMiddle() {
        goal.subValue(CHANGE_VALUE / 2);
        assertEquals(INITIAL_VALUE - CHANGE_VALUE / 2, goal.getGoal());
    }

    @Test
    public void testSubGoalMAX() {
        goal.subValue(INITIAL_VALUE);
        assertEquals(0, goal.getGoal());
    }

    @Test
    public void testSubGoalMultiple() {
        goal.subValue(CHANGE_VALUE);
        goal.subValue(CHANGE_VALUE);
        assertEquals(INITIAL_VALUE - CHANGE_VALUE * 2, goal.getGoal());
    }



}
