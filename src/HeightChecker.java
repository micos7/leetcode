import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        //https://leetcode.com/problems/height-checker/ 1051
        int[] clone = heights.clone();
        Arrays.sort(clone);
        int no = 0;
        for(int i =0;i<heights.length;i++){
            if(heights[i] != clone[i]){
                no++;
            }
        }

        return no;
    }
}
