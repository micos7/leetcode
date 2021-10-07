import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    //https://leetcode.com/problems/find-median-from-data-stream/ 295
    private PriorityQueue<Integer> maxheap = null;
    private PriorityQueue<Integer> minheap = null;

    public MedianFinder() {
        maxheap = new PriorityQueue<Integer>((a,b) -> (b-a));
        minheap = new PriorityQueue<Integer>((a,b) -> (a-b));
    }

    public void addNum(int num) {
        if(maxheap.size() == 0 || maxheap.peek() >= num){
            maxheap.offer(num);
        }else{
            minheap.offer(num);
        }

        balance();
    }

    public double findMedian() {
        if(maxheap.size() > minheap.size()){
            return maxheap.peek();
        }else if(maxheap.size() < minheap.size()){
            return minheap.peek();
        }else{
            return (maxheap.peek() + minheap.peek()) /2.0;
        }
    }

    private void balance(){
        if(maxheap.size() - minheap.size() > 1){
            minheap.offer(maxheap.poll());
        }else if (minheap.size() - maxheap.size() > 1){
            maxheap.offer(minheap.poll());
        }
    }
}
