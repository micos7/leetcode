public class ApplyDiscounttoPrices {
    public String discountPrices(String sentence, int discount) {
        //https://leetcode.com/problems/apply-discount-to-prices/ 2288
        String[] strList = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String s : strList) {
            if (valid(s)) {
                long val = Long.parseLong(s.substring(1));
                ans.append("$" + String.format("%.2f", val * (1 - discount / 100.0d)));
            } else {
                ans.append(s);
            }
            ans.append(" ");
        }
        return ans.toString().substring(0, ans.length() - 1);
    }


    private boolean valid(String s) {
        if (s.length() <= 1) {
            return false;
        }

        if (s.charAt(0) != '$') {
            return false;
        }


        for (int i = 1; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
