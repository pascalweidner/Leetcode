import java.util.Arrays;

public class DistributeCandiestoPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int n = num_people;
        double f = (double) (n * (n + 1)) / 2;
        double a = n * n;  // n^2
        double b = (1 + 2 * f);
        double c = -2 * (candies - f);

        double sqrt = Math.sqrt(b * b - 2 * a * c);
        double k1 = (-b + sqrt) / (2 * a);
        double k2 = (-b - sqrt) / (2 * a);
        System.out.println(k1);
        System.out.println(k2);
        int full_rounds;
        if(k1 < 0) {
            full_rounds = (int) Math.floor(k1 + 1);
        }
        else {
            full_rounds = (int) Math.round(k1 + 1);
        }

        int[] result = new int[num_people];
        int candies_rest = candies - (int) (num_people * num_people * ((double) (full_rounds * (full_rounds - 1)) / 2) + full_rounds * f);
        System.out.println(full_rounds);
        for(int i = 0;  i < num_people; i++) {
            int candies_full =  full_rounds * (i+1) + num_people * (full_rounds * (full_rounds - 1) / 2);
            int candies_r = full_rounds * num_people + i + 1;
            int candies_real = Math.min(candies_r, candies_rest);
            System.out.println(candies_real);
            candies_rest -= candies_real;
            result[i] = candies_full + candies_real;
        }

        System.out.println(Arrays.toString(result));

        return result;
    }
}
