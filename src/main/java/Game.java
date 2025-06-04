import java.security.Guard;

public class Game {

    public String question;

    public GameResult guess(String guessNumber) {
        assertIllegalAargument(guessNumber);
        if (guessNumber.equals(question)) {
            return new GameResult(true, 3, 0);
        } else {
            return new GameResult(false, getStrikes(guessNumber), getBalls(guessNumber));
        }

    }

    private int getBalls(String guessNumber) {
        int balls=0;
        for (int i = 0; i < 3; i++) {
            if (guessNumber.charAt(i) == question.charAt(i)) {
            } else if (judge(question, guessNumber.charAt(i))){
                balls++;
            }
        }
        return balls;
    }

    private int getStrikes(String guessNumber) {
        int strikes=0;
        for (int i = 0; i < 3; i++) {
            if (guessNumber.charAt(i) == question.charAt(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private boolean judge(String question, char answer) {
        for (char s : question.toCharArray()) {
            if (s == answer) return true;
        }
        return false;
    }

    private void assertIllegalAargument(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }

        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char number : guessNumber.toCharArray()) {
            if (number < '0' || number > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (isDuplicatedNumber(guessNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicatedNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(1) == guessNumber.charAt(2)
                || guessNumber.charAt(0) == guessNumber.charAt(2);
    }
}
