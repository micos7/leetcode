public class PercentageofLetterinString {
    public int percentageLetter(String s, char letter) {
        //https://leetcode.com/problems/percentage-of-letter-in-string/ 2278
        int count = 0;
        for(char c: s.toCharArray()) {
            if(c == letter) {
                count++;
            }
        }
        return (100*count)/s.length();
    }
}
