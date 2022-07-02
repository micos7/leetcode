import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        //https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/ 1647
        int ans = 0;

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        Set<Integer> uniquefrequencies = new HashSet<Integer>();
        for(int count : freq){
            while(count > 0 && uniquefrequencies.contains(count)){
                ans++;
                count--;
            }
            uniquefrequencies.add(count);

        }

        return ans;
    }
}
