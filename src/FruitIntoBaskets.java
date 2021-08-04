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

    public int totalFruit(int[] fruits) {
        int last_fruit = -1;
        int second_last_fruit = -1;
        int last_fruit_count = 0;
        int current_max= 0;
        int max = 0;

        for(int fruit : fruits){
            if(fruit == last_fruit || fruit == second_last_fruit){
                current_max++;
            }else{
                current_max = last_fruit_count + 1;
            }

            if(fruit == last_fruit){
                last_fruit_count++;
            }else{
                last_fruit_count = 1;
            }

            if(fruit != last_fruit){
                second_last_fruit = last_fruit;
                last_fruit = fruit;
            }

            max = Math.max(max,current_max);
        }

        return max;

    }
}
