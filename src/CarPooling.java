public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        //https://leetcode.com/problems/car-pooling/ 1094
        int[] occupancy = new int[1001];
        for(int i =0;i<trips.length;i++){
            occupancy[trips[i][1]]+=trips[i][0];
            occupancy[trips[i][2]]-=trips[i][0];
        }

        for(int o:occupancy){
            capacity-=o;
            if(capacity<0){
                return false;
            }
        }

        return true;
    }
}
