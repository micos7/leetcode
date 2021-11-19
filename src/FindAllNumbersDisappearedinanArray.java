import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int num = Math.abs(nums[i]) -1;
            if(nums[num] > 0){
                nums[num] = -nums[num];
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > 0){
                l.add(i+1);
            }
        }

        return l;
    }
}
