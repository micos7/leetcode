import java.util.ArrayList;
import java.util.List;

public class FindGoodDaystoRobtheBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        //https://leetcode.com/problems/find-good-days-to-rob-the-bank/ 2100
        int[] left = new int[security.length];
        int[] right = new int[security.length];

        for(int i = 1;i<security.length;i++){
            if(security[i] > security[i-1]){
                left[i] = 0;
            }else{
                left[i] = left[i-1]+1;
            }
        }

        for(int i = security.length-2;i>=0;i--){
            if(security[i] > security[i+1]){
                right[i] = 0;
            }else{
                right[i] = right[i+1]+1;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = time;i < security.length - time;i++){
            if(right[i] >= time && left[i] >= time){
                ans.add(i);
            }
        }

        return ans;
    }
}
