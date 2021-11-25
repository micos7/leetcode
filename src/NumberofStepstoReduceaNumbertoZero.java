public class NumberofStepstoReduceaNumbertoZero {
    public int numberOfSteps(int num) {
        //https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/ 1342
        return helper(0,num);
    }

    private int helper(int count,int num){
        if(num <= 0){
            return count;
        }
        if(num%2 == 0){
            return helper(count+1,num/2);
        }else{
            return helper(count+1,num-1);
        }
    }
}
