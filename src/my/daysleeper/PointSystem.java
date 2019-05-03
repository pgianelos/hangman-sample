package my.daysleeper;

public class PointSystem {

    private static final int BONUS_FOR_TRY_LEFT = 20;
    private static final int BONUS_FOR_LETTER_SPREE = 5;
    private static final int BONUS_FOR_LETTER = 10;

    private int totalPoints = 0;

    public void addPointsForLetterFound(int letterOccurencies) {
        totalPoints += letterOccurencies * BONUS_FOR_LETTER;
    }

    public void addPointsForTriesLeft(int triesLeft) {
        totalPoints += triesLeft * BONUS_FOR_TRY_LEFT;
    }

    public void addPointsForLetterSpree() {
        totalPoints += BONUS_FOR_LETTER_SPREE;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
