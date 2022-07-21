import java.util.Arrays;
import java.util.HashMap;

public class RankTransformofanArray {
    public int[] arrayRankTransform(int[] arr) {
        //https://leetcode.com/problems/rank-transform-of-an-array/ 1331
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        HashMap<Integer, Integer> rank = new HashMap<>();

        for (int s : sorted) rank.putIfAbsent(s, rank.size() + 1);
        for (int i = 0; i < arr.length; ++i) arr[i] = rank.get(arr[i]);
        return arr;
    }
}
