public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //https://leetcode.com/problems/gas-station/ 134
        int tank = 0, total = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            int fuelNeed = gas[i] - cost[i];
            tank += fuelNeed;
            if (tank < 0) {
                index = i + 1;
                tank = 0;
            }
            total += fuelNeed;
        }
        return total < 0 ? -1 : index;
    }
}
