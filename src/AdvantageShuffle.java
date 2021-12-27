import java.util.TreeMap;

public class AdvantageShuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        //https://leetcode.com/problems/advantage-shuffle/ 870
        TreeMap<Integer,Integer> m = new TreeMap<>();
        for(int n:nums1){
            m.put(n,m.getOrDefault(n,0)+1);
        }

        int[] ans = new int[nums1.length];
        for(int i=0;i<nums2.length;i++){
            Integer val = m.higherKey(nums2[i]);
            if(val == null){
                val = m.firstKey();
            }
            ans[i] = val;
            m.put(val,m.get(val)-1);
            if(m.get(val) == 0){
                m.remove(val);
            }
        }

        return ans;
    }
}
