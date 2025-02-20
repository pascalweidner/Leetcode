public class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        if(arr.length < 3) return 0;
        int lM = 0;
        int currentMountain = 0;
        int up = 0;
        int ptr = 1;
        boolean alreadyUp = false;
        boolean alreadyDown = false;
        while(ptr <= arr.length - 1) {
            int upNew = Integer.compare(arr[ptr], arr[ptr - 1]);

            if(up == 1) alreadyUp = true;

            if(((up == 0 || up == 1) && upNew == 1) || ((up == 1 || up == -1) && upNew == -1 && alreadyUp)) {
                currentMountain++;
            } else if(up == -1 && upNew == 1) {
                currentMountain++;
                if(currentMountain >= 3) {
                    lM = Math.max(lM, currentMountain);
                }
                currentMountain = 0;
                currentMountain++;
            } else if(up == -1 && upNew == 0) {
                currentMountain++;
                if(currentMountain >= 3) {
                    lM = Math.max(lM, currentMountain);
                }
                currentMountain = 0;
            } else if(up == 1 && upNew == 0) {
                currentMountain = 0;
            }

            if(upNew == -1 && alreadyUp) alreadyDown = true;

            up = upNew;
            ptr++;
        }

        if(up == -1) currentMountain++;

        if(alreadyDown && up == -1) {
            lM = Math.max(lM, currentMountain);
        }

        return lM;
    }
}
