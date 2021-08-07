public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        //https://leetcode.com/problems/container-with-most-water/ 11
        //limit exceeded
        int area = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return area;
    }

    //O(n) solution accepted
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length-1;

        while(i<j){
            area = Math.max(area,Math.min(height[i],height[j]) * (j-i));
            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }

        }

        return area;
    }
}
