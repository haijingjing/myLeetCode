import java.util.Arrays;
import java.util.PriorityQueue;

//253 最小会议室数量
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int count = 0;
        int result = 0;
        for(int i = 0, j = 0; i < starts.length;){
            if(starts[i] < ends[j]){
                count ++;
                i ++;
                result = Math.max(result, count);
            }else {
                j ++;
                count --;
            }
        }
        return result;
    }

    public int minMeetingRooms2(Interval[] intervals) {
        Arrays.sort(intervals,(a, b) -> a.start - b.start);
        int rooms = 0;
        int active = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < intervals.length; i++){
            while (!heap.isEmpty() && heap.peek() <= intervals[i].start){
                active --;
                heap.poll();
            }
            active ++;
            heap.add(intervals[i].end);
            rooms = Math.max(rooms, active);
        }
        return rooms;
    }

}
