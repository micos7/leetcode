public class ArrangingCoins {
    //https://leetcode.com/problems/arranging-coins/ 441
    public int arrangeCoins(int n) {
        int rows =0;
        while(n > 0){
            rows +=1;
            n -= rows;
        }

        return n==0 ?rows : rows-1;
    }
}
