package day07;

/**
 * 사용자가 점수를 음수로 입력한 경우 발생하는 예외
 */

public class NegativeScoreExceptionT extends Exception {
    public NegativeScoreExceptionT() {
        super("Negative score are not valid.");
    }
}
