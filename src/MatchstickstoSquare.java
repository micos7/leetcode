import java.util.Arrays;

public class MatchstickstoSquare {
    public boolean makesquare(int[] matchsticks) {
        //https://leetcode.com/problems/matchsticks-to-square/ 473
        if (matchsticks.length < 4) return false;
        int total = 0;
        for (int m : matchsticks) {
            total += m;
        }
        Arrays.sort(matchsticks);
        if (total % 4 != 0) return false;
        int side = total / 4;

        int[] sides = new int[]{side, side, side, side};

        return traverse(matchsticks, matchsticks.length - 1, sides);
    }

    private boolean traverse(int[] nums, int index, int[] sides) {
        if (index < 0) {
            return sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0;
        }

        for (int j = 0; j < 4; j++) {
            if (nums[index] > sides[j]) continue;
            sides[j] -= nums[index];
            if (traverse(nums, index - 1, sides)) return true;
            sides[j] += nums[index];
        }

        return false;
    }
}
