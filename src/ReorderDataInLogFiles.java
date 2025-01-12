import java.util.Arrays;
import java.util.List;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String> l = Arrays.asList(logs);
        Arrays.sort(logs, (a, b) -> {
            int firstSpaceA = a.indexOf(" ");
            int firstSpaceB = b.indexOf(" ");
            String[] aA = a.split(" ", 2);
            String[] bA = b.split(" ", 2);
            if (aA[1].matches("[a-zA-Z\\s]*") && bA[1].matches("[\\d\\s]*")) return -1;
            if (aA[1].matches("[a-zA-Z\\s]*") && bA[1].matches("[a-zA-Z\\s]*")) {
                int equal = aA[1].compareTo(bA[1]);
                equal = equal == 0 ? aA[0].compareTo(bA[0]) : equal;
                return equal;
            }
            if(aA[1].matches("[\\d\\s]*") && bA[1].matches("[\\d\\s]*")) {
                return Integer.compare(l.indexOf(a), l.indexOf(b));
            }
            return 1;
        });
        return logs;
    }
}
