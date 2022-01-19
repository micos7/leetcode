import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //https://leetcode.com/problems/cheapest-flights-within-k-stops/ 787
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        Map<Integer, Integer> minKFromPlace = new HashMap<>();

        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, price);
        }

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, src, k});

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int price = cur[0];
            int place = cur[1];
            int stopsLeft = cur[2];

            if (place == dst) return price;
            if (stopsLeft < minKFromPlace.getOrDefault(place, 0) || !graph.containsKey(place)) continue;
            minKFromPlace.put(place, stopsLeft);

            Map<Integer, Integer> tos = graph.get(place);

            for (Map.Entry<Integer, Integer> entry : tos.entrySet()) {
                minHeap.offer(new int[]{price + entry.getValue(), entry.getKey(), stopsLeft - 1});
            }
        }

        return -1;
    }
}
