import java.util.HashMap;
import java.util.Map;

public class CountVowelsPermutation {
    //https://leetcode.com/problems/count-vowels-permutation/ 1220
    private Map<String, Long> map = new HashMap<String, Long>();

    public int countVowelPermutation(int n) {
        long total = 0;
        char[] charset = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (char c : charset) {
            total = (total + builder(n - 1, c)) % 1000000007;
        }
        return (int) total;
    }


    public long builder(int remainingChar, char previousChar) {
        if (remainingChar == 0) return 1;

        String key = "" + remainingChar + previousChar;
        if (map.containsKey(key)) return map.get(key);
        long total = 0;
        switch (previousChar) {
            case 'a':
                total = (builder(remainingChar - 1, 'e')) % 1000000007;
                break;
            case 'e':
                total = (builder(remainingChar - 1, 'a') + builder(remainingChar - 1, 'i')) % 1000000007;
                break;
            case 'i':
                total = (builder(remainingChar - 1, 'a') + builder(remainingChar - 1, 'e') + builder(remainingChar - 1, 'o') + builder(remainingChar - 1, 'u')) % 1000000007;
                break;
            case 'o':
                total = (builder(remainingChar - 1, 'i') + builder(remainingChar - 1, 'u')) % 1000000007;
                break;
            case 'u':
                total = (builder(remainingChar - 1, 'a')) % 1000000007;
                break;
        }
        map.put(key, total);
        return total;
    }
}
