import java.util.Arrays;

public class ValidTriangleNumber {
    //https://leetcode.com/problems/valid-triangle-number 611
    public int triangleNumber(int[] nums) {
        //O(n^3) doesnt finish
        int triangles = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int z = j + 1; z < nums.length; z++) {

                    if (nums[i] + nums[j] > nums[z]
                            && nums[i] + nums[z] > nums[j]
                            && nums[z] + nums[j] > nums[i]) {
                        triangles++;
                    }
                }

            }

        }

        return triangles;

    }


    public int triangleNumber(int[] nums) {
        //O(n^2)
        int triangles = 0;

        Arrays.sort(nums);

        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i-1;

            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    triangles += right-left;
                    right--;
                }else {
                    left++;
                }
            }
        }

        return triangles;
    }
}
