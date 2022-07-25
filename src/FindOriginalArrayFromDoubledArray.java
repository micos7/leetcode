import java.util.*;

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        //https://leetcode.com/problems/find-original-array-from-doubled-array/ 2007
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : changed)
            map.put(c, map.getOrDefault(c, 0) + 1);
        Arrays.sort(changed);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < changed.length; i++) {
            int freq = map.getOrDefault(changed[i], 0);
            if (freq > 0) {
                map.put(changed[i], freq - 1);
                int twice = changed[i] * 2;
                int freq_double = map.getOrDefault(twice, 0);
                if (freq_double > 0)
                    res.add(changed[i]);
                map.put(twice, freq_double - 1);
            }
        }
        if (res.size() * 2 != changed.length)
            return new int[0];
        int[] ans = new int[res.size()];
        int k = 0;
        for (int n : res)
            ans[k++] = n;
        return ans;

    }
}
