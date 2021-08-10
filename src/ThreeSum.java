import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //https://leetcode.com/problems/3sum/  15
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;


        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int low = i + 1;
            int high = n - 1;

            while (low < high) {
                int temp = nums[low] + nums[high] + nums[i];
                if (temp == 0) {
                    res.add(Arrays.asList(new Integer[]{nums[low], nums[high], nums[i]}));
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;

                } else if (temp < 0) {
                    low++;
                } else {
                    high--;
                }
            }

        }

        return res;

    }
}
