import java.util.Random;

public class ShuffleanArray {
    //https://leetcode.com/problems/shuffle-an-array/ 384
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = nums.clone();

        for(int i = nums.length-1;i>0;i--){
            int j = random.nextInt(i+1);
            int t = copy[i];
            copy[i] = copy[j];
            copy[j] = t;
        }

        return copy;

    }
}
