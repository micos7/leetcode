import java.util.Collections;

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals){
        //https://leetcode.com/problems/meeting-rooms/
        Collections.sort(intervals,(a,b) -> a.start - b.start);
        for(int i =1;i< intervals.size();i++){
            if(intervals.get(i-1).end > intervals.get(i).start){
                return false;
            }
        }

        return true;
    }
}
