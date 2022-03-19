import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        //https://leetcode.com/problems/assign-cookies/ 455
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int r = 0;
        while (l < g.length && r < s.length) {
            if (g[l] <= s[r]) {
                l++;
                r++;
            } else {
                r++;
            }
        }
        return l;
    }
}
