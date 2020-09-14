import java.util.ArrayList;

public class BowlingGame {
    private final Integer ALL_ROUND_NUM = 2;
    private final Integer ALL_GAME_TIMES = 10;

    private Integer roundNum;
    private Integer gameTimes;
    private int res;

    private void initArgs() {
        roundNum = 0;
        gameTimes = 0;
        res = 0;
    }

    void playGame(ArrayList<Integer> hitBollNums) {
        initArgs();
        calculateGrade(hitBollNums);
    }

    private void calculateGrade(ArrayList<Integer> hitBollNums) {
        for (Integer hitBollNum: hitBollNums) {
            if (isTimeToStartNewRound()) {
                startNewRound();
            }
            if (isTimeEndGame()) break;

            getGrade(hitBollNum);

            roundNum ++;
        }
    }

    private void getGrade(Integer hitBollNum) {
        res += hitBollNum;
    }

    private void startNewRound() {
        gameTimes ++;
        roundNum = 0;
    }

    private Boolean isTimeToStartNewRound() {
        return roundNum.equals(ALL_ROUND_NUM);
    }

    private Boolean isTimeEndGame() {
        return gameTimes.equals(ALL_GAME_TIMES);
    }

    int getGrade() {
       return res;
    }
}
