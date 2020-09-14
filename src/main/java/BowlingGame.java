import java.util.ArrayList;

public class BowlingGame {
    private final Integer ALL_ROUND_NUM = 2;
    private final Integer ALL_GAME_TIMES = 10;
    private final Integer MAX_GRADE = 10;

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
        for (int i = 0; i < hitBollNums.size(); ++i)
        {
            if (isTimeToStartNewRound()) {
                startNewRound();
                if (ifPrevTimeSpare(hitBollNums.get(i-2), hitBollNums.get(i-1))) getSpareGrade(hitBollNums.get(i));
            }
            if (isTimeEndGame()) break;

            getGrade(hitBollNums.get(i));
            if (ifStrike(hitBollNums.get(i)))  {
                getStrikeGrade(hitBollNums.get(i+1), hitBollNums.get(i+2));
                startNewRound();
                continue;
            }
            roundNum ++;
        }
    }


    private void getSpareGrade(Integer hitBollNum) {
        res += hitBollNum;
    }

    private void getStrikeGrade(Integer hitBollNum1, Integer hitBollNum2) {
        res += hitBollNum1 + hitBollNum2;
    }

    private Boolean ifStrike(Integer hitBollNum) {
        return hitBollNum == 10;
    }

    private Boolean ifPrevTimeSpare(Integer prePreHitBollNum, Integer preHitBollNum) {
        if (gameTimes < 1 || gameTimes >= ALL_GAME_TIMES) return false;
        return preHitBollNum + prePreHitBollNum == 10;
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
