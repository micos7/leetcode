public class PartitiontoKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //https://leetcode.com/problems/partition-to-k-equal-sum-subsets/ 698
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        if (total % k != 0) {
            return false;
        }
        int partSum = total / k;
        boolean[] visited = new boolean[nums.length];

        return helper(nums, 0, 0, k, partSum, visited);
    }

    private boolean helper(int[] nums, int idx, int sum, int k, int partSum, boolean[] visited) {
        if (k == 0) return true;
        if (sum > partSum) return false;
        if (sum == partSum) {
            return helper(nums, 0, 0, k - 1, partSum, visited);
        }

        for (int i = idx; i < nums.length; i++) {
            if (!visited[i] && sum + nums[i] <= partSum) {
                visited[i] = true;
                if (helper(nums, i + 1, sum + nums[i], k, partSum, visited)) return true;
                visited[i] = false;
            }

        }
        return false;
    }
}
