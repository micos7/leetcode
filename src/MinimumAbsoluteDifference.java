import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //https://leetcode.com/problems/minimum-absolute-difference/ 1200
        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for(int i =0;i<arr.length-1;i++){
            min = Math.min(min,arr[i+1] - arr[i]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<arr.length-1;i++){
            if(arr[i] +min == arr[i+1]){
                ans.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }

        return ans;
    }
}
