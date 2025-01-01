import java.util.*;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> visits = new HashMap<>();

        for(String dom : cpdomains) {
            String[] s = dom.split(" ");
            int visit = Integer.parseInt(s[0]);
            String domain = s[1];

            while(!domain.isEmpty()) {

                visits.putIfAbsent(domain, 0);
                visits.compute(domain, (key, val) -> val + visit);
                int index;
                if((index = domain.indexOf('.')) != -1) {
                    domain = domain.substring(domain.indexOf('.') + 1);
                }
                else break;
            }
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: visits.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        System.out.println(result);
        return result;
    }
}
