import java.util.Arrays;

public class LetterTilePossibilities {
    int count = 0;
    public int numTilePossibilities(String tiles) {
        //https://leetcode.com/problems/letter-tile-possibilities/ 1079
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        int[] seen = new int[tiles.length()];
        rec(seen,chars);
        return count;
    }

    private void rec(int[] seen,char[] chars){
        for(int i=0;i<chars.length;i++){
            if(seen[i] == 1 || (i > 0 && chars[i-1] == chars[i] && seen[i-1] == 0)){
                continue;
            }
            count++;
            seen[i] =1;
            rec(seen,chars);
            seen[i]=0;
        }
    }
}
