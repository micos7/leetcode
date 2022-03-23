import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        //https://leetcode.com/problems/reverse-vowels-of-a-string/ 345
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] ar = s.toCharArray();

        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !set.contains(ar[l])) {
                l++;
            }
            while (l < r && !set.contains(ar[r])) {
                r--;
            }
            char temp = ar[l];
            ar[l++] = ar[r];
            ar[r--] = temp;
        }
        return new String(ar);
    }
}
