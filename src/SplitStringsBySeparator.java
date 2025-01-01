import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SplitStringsBySeparator {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>(words.size());
        for(String s : words) {
            StringBuilder cache = new StringBuilder();
            for(char c : s.toCharArray()) {
                if (c == separator && !cache.isEmpty()) {
                    result.add(cache.toString());
                    cache = new StringBuilder();
                }
                else if(c != separator) {
                    cache.append(c);
                }
            }

            if(!cache.isEmpty() && !cache.toString().equals(String.valueOf(separator))) {
                result.add(cache.toString());
            }
        }

        return result;
    }

    public static void main(String[] args) {
            /*
            StringTokenizer st = new StringTokenizer(s, String.valueOf(separator), true);
            while(st.hasMoreTokens()) {
                String r = st.nextToken();
                if(!r.equals(String.valueOf(separator))) result.add(r);
            }
             */
        var s = new SplitStringsBySeparator();
        var t = s.splitWordsBySeparator(List.of("one.two.three","four.five","six"), '.');
        System.out.println(t);
    }
}
