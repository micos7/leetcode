public class MinimumNumberofStepstoMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        //https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/ 1347
        int count = 0;
        int[] cnt = new int[26];

        for(char c:s.toCharArray()){
            cnt[c-'a']++;
        }

        for(char c:t.toCharArray()){
            if(cnt[c-'a'] > 0){
                cnt[c-'a']--;
            }else{
                count++;
            }
        }
        return count;
    }
}
