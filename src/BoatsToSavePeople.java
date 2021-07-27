import java.util.Arrays;

public class BoatsToSavePeople {
    //https://leetcode.com/problems/boats-to-save-people/ 881
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        int left = 0;
        int right = people.length - 1;

        Arrays.sort(people);

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            boats++;
        }

        return boats;
    }
}
