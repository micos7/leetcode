import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        //https://leetcode.com/problems/jump-game-iv/ 1345
        if(arr.length == 1)
            return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int steps =0;

        for(int i =0;i<arr.length;i++){
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){
            steps++;
            int size = q.size();

            for(int i = 0;i<size;i++){
                int j = q.poll();

                if(j-1 >= 0 && map.containsKey(arr[j-1])){
                    q.offer(j-1);
                }

                if(j+1 < arr.length && map.containsKey(arr[j+1])){
                    if(j+1 == arr.length-1) return steps;
                    q.offer(j+1);
                }

                if(map.containsKey(arr[j])){
                    for(int k :map.get(arr[j])){
                        if(k != j){
                            if(k == arr.length-1) return steps;
                            q.offer(k);
                        }
                    }
                }

                map.remove(arr[j]);
            }
        }

        return steps;
    }
}
