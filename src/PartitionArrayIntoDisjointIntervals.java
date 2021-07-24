public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] nums) {
        //https://leetcode.com/problems/partition-array-into-disjoint-intervals/ 915
        int maxUntilI = nums[0];
        int maxInLeftPartition = nums[0];
        int partitionIdx = 0;

        for(int i=1;i<nums.length;i++){
            maxUntilI = Math.max(maxUntilI, nums[i]);
            if(nums[i] < maxInLeftPartition){
                maxInLeftPartition = maxUntilI;
                partitionIdx = i;
            }
        }

        return partitionIdx +1;
    }
}
