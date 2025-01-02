import java.util.Arrays;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        int count = 0;
        for(int cost :costs) {
            if((sum += cost) > coins) {
                break;
            }
            count++;
        }

        return count;
    }
}
