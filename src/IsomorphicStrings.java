import java.util.HashMap;

public class IsomorphicStrings {
    //https://leetcode.com/problems/isomorphic-strings/ 205
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sm = new HashMap<>();
        HashMap<Character, Character> tm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);

            if (sm.containsKey(sc)) {
                if (sm.get(sc) != tc) {
                    return false;
                }
            }

            if (tm.containsKey(tc)) {
                if (tm.get(tc) != sc) {
                    return false;
                }
            }

            sm.put(sc, tc);
            tm.put(tc, sc);
        }

        return true;
    }
}
