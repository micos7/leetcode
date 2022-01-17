public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        //https://leetcode.com/problems/jump-game-iii/ 1306
        return traverse(arr, start, 0);
    }

    private boolean traverse(int[] arr, int index, int count) {
        if (index >= arr.length || index < 0) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }

        if (count > arr.length) {
            return false;
        }

        return traverse(arr, index + arr[index], count + 1) ||
                traverse(arr, index - arr[index], count + 1);


    }
}
