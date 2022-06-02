public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //https://leetcode.com/problems/corporate-flight-bookings/ 1109
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            int a = booking[0] - 1, b = booking[1] - 1, seat = booking[2];
            for (int i = a; i <= b; i++) {
                ans[i] += seat;
            }
        }

        return ans;
    }
}
