import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingGameTest {

    @Test
    void should_return_sum() throws HitTimesNotEnoughException {
        // given
        BowlingGame bowlingGame = new BowlingGame();
        ArrayList<Integer> hitBollNums = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2));

        // when
        bowlingGame.playGame(hitBollNums);

        // then
        assertEquals(30, bowlingGame.getGrade());
    }

    @Test
    void should_return_sum_with_at_least_one_spare() throws HitTimesNotEnoughException {
        // given
        BowlingGame bowlingGame = new BowlingGame();
        ArrayList<Integer> hitBollNums = new ArrayList<>(Arrays.asList(2, 8, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2));

        // when
        bowlingGame.playGame(hitBollNums);

        // then
        assertEquals(38, bowlingGame.getGrade());
    }

    @Test
    void should_return_sum_with_at_least_one_strike() throws HitTimesNotEnoughException {
        // given
        BowlingGame bowlingGame = new BowlingGame();
        ArrayList<Integer> hitBollNums = new ArrayList<>(Arrays.asList(2, 8, 10, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2));

        // when
        bowlingGame.playGame(hitBollNums);

        // then
        assertEquals(57, bowlingGame.getGrade());
    }

    @Test
    void should_return_sum_with_tenth_strike() throws HitTimesNotEnoughException {
        // given
        BowlingGame bowlingGame = new BowlingGame();
        ArrayList<Integer> hitBollNums = new ArrayList<>(Arrays.asList(2, 8, 10, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 10, 2, 8, 1, 2));

        // when
        bowlingGame.playGame(hitBollNums);

        // then
        assertEquals(74, bowlingGame.getGrade());
    }

    @Test
    void should_return_sum_with_all_hit() throws HitTimesNotEnoughException {
        // given
        BowlingGame bowlingGame = new BowlingGame();
        ArrayList<Integer> hitBollNums = new ArrayList<>(Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));

        // when
        bowlingGame.playGame(hitBollNums);

        // then
        assertEquals(300, bowlingGame.getGrade());
    }

    @Test
    void should_throw_when_hitTimesNotEnough() {
        // given
        BowlingGame bowlingGame = new BowlingGame();
        ArrayList<Integer> hitBollNums = new ArrayList<>(Arrays.asList(1, 2));

        // when & then
        assertThrows(HitTimesNotEnoughException.class, () -> {
            bowlingGame.playGame(hitBollNums);
        });
    }
}
