import java.util.HashMap;

public class FruitIntoBaskets {
    //https://leetcode.com/problems/fruit-into-baskets/ 904
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 1;
        int j = 0;
        int i = 0;

        while (j < fruits.length) {
            if (hm.size() <= 2) {
                hm.put(fruits[j], j++);
            }

            if (hm.size() > 2) {
                int min = fruits.length - 1;
                for (int val : hm.values()) {
                    min = Math.min(min, val);
                }
                i = min + 1;
                hm.remove(fruits[min]);
            }

            max = Math.max(max, j - i);
        }


        return max;
    }
}
