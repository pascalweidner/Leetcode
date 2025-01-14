import java.util.Arrays;

public class DistributeCandiestoPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int round = 0;
        int fullRounds = 0;
        int candyThisRound = calculateCandy(round, num_people);
        int[] result = new int[num_people];
        while(candyThisRound <= candies) {
            candies -= candyThisRound;
            fullRounds++;
            round++;
            candyThisRound = calculateCandy(round, num_people);
        }

        System.out.println(fullRounds);

        return null;

    }

    private int calculateCandy(int round, int n) {
        int f = n * (n+1) / 2;
        return f + n * n * round;
    }
}
