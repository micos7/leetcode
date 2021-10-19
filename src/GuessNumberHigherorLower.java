public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        int left = 1, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == -1) {
                right = mid - 1;
            } else if (res == 0) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
