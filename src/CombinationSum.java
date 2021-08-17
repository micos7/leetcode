import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    //https://leetcode.com/problems/combination-sum/ 39
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }


    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int index) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(tmp));
            }

            return;
        }

        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            helper(res, tmp, candidates, target - candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }


    }
}
