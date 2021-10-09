import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        //https://leetcode.com/problems/top-k-frequent-elements/ 347
        Map<Integer,Integer> m = new HashMap<>();

        for(int i =0;i<nums.length;i++){
            m.put(nums[i], m.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue<>((a, b) ->  b.getValue() - a.getValue());

        for(Map.Entry e: m.entrySet()){
            pq.add(e);
        }

        int[] res = new int[k];

        for(int i = 0;i< k ;i++){
            res[i] = pq.poll().getKey();
        }

        return res;
    }
}
