public class FindtheTownJudge {
    public int findJudge(int n, int[][] trust) {
        //https://leetcode.com/problems/find-the-town-judge/ 997
        int[] count = new int[n+1];
        for(int[] t:trust ){
            count[t[0]]--;
            count[t[1]]++;
        }

        for(int i = 1;i<count.length;i++){
            if(count[i] == n-1){
                return i;
            }
        }

        return -1;
    }
}
