public class NumberofLaserBeamsinaBank {
    public int numberOfBeams(String[] bank) {
        //https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
        int ans = 0;
        int previosDevice=0;
        int[] devices = new int[bank.length-1];
        for(int i =0;i<bank.length;i++){
            int curDevice=0;
            for(char device:bank[i].toCharArray()){
                if(device == '1'){
                    curDevice++;
                }
            }

            if(curDevice>0){
                ans+= curDevice*previosDevice;
                previosDevice = curDevice;
            }
        }

        return ans;
    }
}
