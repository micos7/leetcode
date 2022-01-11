public class AddBinary {
    public String addBinary(String a, String b) {
        //https://leetcode.com/problems/add-binary/ 67
        StringBuilder s = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int x = (i >= 0) ? a.charAt(i) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 2;
            s.append(sum % 2);
            i--;
            j--;
        }
        if (carry != 0) {
            s.append(carry);
        }

        return s.reverse().toString();
    }
}
