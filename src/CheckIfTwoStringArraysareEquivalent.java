public class CheckIfTwoStringArraysareEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        //https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/ 1662
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        for(String s:word1){
            a.append(s);
        }
        for(String s:word2){
            b.append(s);
        }

        return a.toString().equals(b.toString());

    }
}
