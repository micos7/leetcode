public class AddStrings {
    public String addStrings(String num1, String num2) {
    //https://leetcode.com/problems/add-strings/ 415
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuilder sb = new StringBuilder();

        int remainder = 0;


        while (i >= 0 || j >= 0) {
            int sum = remainder;

            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }

            sb.append(sum % 10);

            remainder = sum / 10;


        }

        if (remainder != 0) {
            sb.append(remainder);
        }

        return sb.reverse().toString();
    }
}
