import model.TodayDrinkingGoal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

// Unit tests for TodayDrinkingGoalTest class
public class TodayDrinkingGoalTest {
    private TodayDrinkingGoal goal;
    private int CHANGE_VALUE = 1;
    private int INITIAL_VALUE = 500;

    @BeforeEach
    public void runBefore(){
        goal = new TodayDrinkingGoal(INITIAL_VALUE);
    }

    @Test
    public void testTodayDrinkingGoal() {
        assertEquals(500, goal.getGoal());
    }

    @Test
    public void testAddGoalOnce() {
        goal.addGoal(CHANGE_VALUE);
        assertEquals(INITIAL_VALUE + CHANGE_VALUE, goal.getGoal());
    }

    @Test
    public void testAddGoalMultiple() {
        goal.addGoal(CHANGE_VALUE);
        goal.addGoal(CHANGE_VALUE);
        assertEquals(INITIAL_VALUE + CHANGE_VALUE * 2, goal.getGoal());
    }

    @Test
    public void testSubGoalSmall() {
        goal.subGoal(CHANGE_VALUE);
        assertEquals(INITIAL_VALUE - CHANGE_VALUE, goal.getGoal());
    }

    @Test
    public void testSubGoalMiddle() {
        goal.subGoal(CHANGE_VALUE / 2);
        assertEquals(INITIAL_VALUE - CHANGE_VALUE / 2, goal.getGoal());
    }

    @Test
    public void testSubGoalMAX() {
        goal.subGoal(INITIAL_VALUE);
        assertEquals(0, goal.getGoal());
    }

    @Test
    public void testSubGoalMultiple() {
        goal.subGoal(CHANGE_VALUE);
        goal.subGoal(CHANGE_VALUE);
        assertEquals(INITIAL_VALUE - CHANGE_VALUE * 2, goal.getGoal());
    }



}
