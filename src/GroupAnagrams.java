import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //https://leetcode.com/problems/group-anagrams/ 49
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> hm = new HashMap<>();
        for(String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(!hm.containsKey(sorted)){
                hm.put(sorted,new ArrayList<>());
            }
            hm.get(sorted).add(s);
        }

        ans.addAll(hm.values());

        return ans;
    }
}
