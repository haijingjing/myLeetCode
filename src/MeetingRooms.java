import java.util.Arrays;
import java.util.Comparator;

//252 会议室安排
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals)
    {
        // step 1: sort the intervals
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        });

//        Arrays.sort(intervals,(a, b) -> a.start - b.start);

        // step 2: iterate intervals to check each end is <= next start
        int end = intervals[0].end;

        for (Interval interval : intervals) {
            if (interval.start < end) {
                return false;
            } else {
                end = interval.end;
            }
        }
        return true;
    }
}
