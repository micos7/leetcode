public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        //https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/ 1007
        int minSwaps = Math.min(
                swap(A[0], A, B),
                swap(B[0], A, B)
        );

        minSwaps = Math.min(minSwaps, swap(A[0], B, A));
        minSwaps = Math.min(minSwaps, swap(B[0], B, A));

        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }

    private int swap(int candidate, int[] A, int[] B) {
        int swaps = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != candidate && B[i] != candidate) {
                return Integer.MAX_VALUE;
            } else if (A[i] != candidate) {
                swaps++;
            }
        }
        return swaps;
    }
}
