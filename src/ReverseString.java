public class ReverseString {
    public void reverseString(char[] s) {
        //https://leetcode.com/problems/reverse-string/ 344
        int left =0,right = s.length-1;

        while(left < right){
            char head = s[left];
            char end = s[right];
            char temp = head;
            s[left] = end;
            s[right] = temp;
            left++;
            right--;
        }
    }
}
