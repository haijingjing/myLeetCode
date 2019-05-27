import java.util.*;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
//        intervals.sort((i1, i2) -> i1.start - i2.start);
//        Collections.sort(intervals, (a, b) -> a.start - b.start);;
//        Collections.sort(intervals, new Comparator<Interval>(){
//            public int compare (Interval i1, Interval i2){
//                return i1.start - i2.start;
//            }
//        });

        List<Interval> result = new ArrayList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
