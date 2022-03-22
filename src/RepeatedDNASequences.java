import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        //https://leetcode.com/problems/repeated-dna-sequences/ 187
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> h = new HashMap<>();
        int i = 0;
        while (i + 10 <= s.length()) {
            String seq = s.substring(i, i++ + 10);
            h.put(seq, h.getOrDefault(seq, 0) + 1);
            if (h.get(seq) == 2) ans.add(seq);
        }

        return ans;
    }
}
