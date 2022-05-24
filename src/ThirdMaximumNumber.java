public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        //https://leetcode.com/problems/third-maximum-number/ 414
        Integer first = null, second = null, third = null;

        for (Integer n : nums) {

            if (n.equals(first) || n.equals(second) || n.equals(third)) {
                continue;
            }

            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }

        if (third == null) return first;

        return third;
    }
}
