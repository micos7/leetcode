import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        //https://leetcode.com/problems/sort-characters-by-frequency/ 451
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> (b.getValue() - a.getValue()));
        pq.addAll(hm.entrySet());
        String ans = "";
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            int freq = e.getValue();
            while (freq-- > 0) {
                ans += e.getKey();
            }
        }

        return ans;
    }
}
