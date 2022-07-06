import java.util.TreeMap;

public class CountIntegersinIntervals {
    private TreeMap<Integer, Integer> treeMap;
    private int count;

    public CountIntervals() {
        //https://leetcode.com/problems/count-integers-in-intervals/ 2276
        treeMap = new TreeMap<>();
        count = 0;
    }

    public void add(int left, int right) {

        int l = left;
        int r = right;

        while (!(treeMap.floorKey(r) == null || treeMap.get(treeMap.floorKey(r)) < l)) {

            int smallerLeft = treeMap.floorKey(r);
            int smallerRight = treeMap.get(smallerLeft);

            count -= (smallerRight - smallerLeft + 1);
            treeMap.remove(smallerLeft);

            l = Math.min(l, smallerLeft);
            r = Math.max(r, smallerRight);
        }

        treeMap.put(l, r);
        count += (r - l + 1);

    }

    public int count() {
        return count;
    }
}
