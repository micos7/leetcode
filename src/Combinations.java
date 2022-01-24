import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        //https://leetcode.com/problems/combinations/ 77
        if(k>n){
            return ans;
        }
        List<Integer> temp = new ArrayList<>();

        dfs(1,temp,k,n);
        return ans;

    }

    private void dfs(int start,List<Integer> temp,int k,int n){
        if(k == temp.size()){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i=start;i<=n;i++){
            temp.add(i);
            dfs(i+1,temp,k,n);
            temp.remove(temp.size()-1);
        }
    }
}
