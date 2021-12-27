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
    //priority queue
    public int[] advantageCount(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(b[1] - a[1]));
        for(int i=0;i<nums1.length;i++){
            pq.offer(new int[]{i,nums2[i]});
        }

        int low = 0;
        int high = nums1.length-1;
        Arrays.sort(nums1);

        while(!pq.isEmpty()){
            int[] head =pq.poll();
            int max = head[1];
            int index = head[0];

            if(nums1[high] > max){
                ans[index] = nums1[high];
                high--;
            }else{
                ans[index] = nums1[low];
                low++;
            }
        }

        return ans;
    }
}
