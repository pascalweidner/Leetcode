import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CombinationIterator {
    private char[] chars;
    private int combinationLength;
    private int[] indices;

    public CombinationIterator(String characters, int combinationLength) {
        this.chars = characters.toCharArray();
        this.combinationLength = combinationLength;
        indices = new int[combinationLength];
        Arrays.setAll(indices, operand -> operand);
    }

    private void incrementIndices() {
        if(indices.length == 1) {
            if(indices[0] == chars.length - 1) indices[0] = -1;
            else indices[0]++;
            return;
        }
        for (int i = indices.length - 1; i > 0; i--) {
            if (indices[i] == chars.length - 1 - (indices.length - i - 1)) {
                if (indices[i - 1] < chars.length - 1 - (indices.length - i)) {
                    indices[i - 1]++;
                    int diff = indices[i] - (indices[i - 1] + 1);
                    for (int j = indices.length - 1; j > i - 1; j--) {
                        indices[j] -= diff;
                    }
                    break;
                } else if(i == 1 && indices[0] == indices[1] - 1) {
                     indices[0] = -1;
                     break;
                }
            } else {
                indices[i]++;
                break;
            }
        }


    }

    public String next() {
        String result = Arrays.stream(indices).mapToObj(i -> String.valueOf(chars[i])).collect(Collectors.joining());
        incrementIndices();
        return result;
    }

    public boolean hasNext() {
        return indices[0] != -1;
    }

}