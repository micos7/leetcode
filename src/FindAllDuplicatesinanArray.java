import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllDuplicatesinanArray {
    //https://leetcode.com/problems/find-all-duplicates-in-an-array/ 442
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> l = new ArrayList<>();
        for(int n: nums){
            if(hs.contains(n)){
                l.add(n);
            }else{
                hs.add(n);
            }
        }
        return l;
    }

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] < 0){
                l.add(idx +1);
            }else{
                nums[idx] = -nums[idx];
            }
        }
        return l;
    }
}
