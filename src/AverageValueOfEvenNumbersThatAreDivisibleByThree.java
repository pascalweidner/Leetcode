import java.util.Arrays;

public class AverageValueOfEvenNumbersThatAreDivisibleByThree {
    public int averageValue(int[] nums) {
        return (int) Arrays.stream(nums).filter(i -> (i & 1) == 0).filter(i -> i % 3 == 0).average().orElse(0);
    }
}
