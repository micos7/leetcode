public class FindPeakElement {
    //https://leetcode.com/problems/find-peak-element/ 162
    //O(n)
    public int findPeakElement(int[] nums) {
        for(int i = 1;i<nums.length;i++){
            if(i+1 < nums.length){
                if(nums[i-1] < nums[i] && nums[i] > nums[i+1] ){
                    return i;
                }
            }else{
                if(nums[i-1] < nums[i]){
                    return i;
                }
            }

        }
        return 0;
    }


    //O(logn)
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] < nums[mid+1]){
                low = mid +1;
            }else{
                high = mid;
            }

        }

        return low;
    }
}
