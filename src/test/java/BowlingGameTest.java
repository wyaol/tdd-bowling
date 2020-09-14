import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

    @Test
    void should_return_sum() {
        // given
        BowlingGame bowlingGame = new BowlingGame();
        ArrayList<Integer> hitBollNums = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2));

        // when
        bowlingGame.playGame(hitBollNums);

        // then
        assertEquals(30, bowlingGame.getGrade());
    }

    @Test
    void should_return_sum_with_at_least_one_spare() {
        // given
        BowlingGame bowlingGame = new BowlingGame();
        ArrayList<Integer> hitBollNums = new ArrayList<>(Arrays.asList(2, 8, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2));

        // when
        bowlingGame.playGame(hitBollNums);

        // then
        assertEquals(38, bowlingGame.getGrade());
    }
}
