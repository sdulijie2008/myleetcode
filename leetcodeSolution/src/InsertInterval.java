/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.isEmpty() || intervals.get(intervals.size() -1).end < newInterval.start) {
            intervals.add(newInterval);
            return intervals;
        }
        
        int start = -1, end = intervals.size() - 1;
        
        for (int i = 0; i < intervals.size(); ++i) {
            if (intervals.get(i).start <= newInterval.start && intervals.get(i).end >= newInterval.start) {
                newInterval.start = intervals.get(i).start;
                start = i;
            }
            
            if (start == -1 && newInterval.start < intervals.get(i).start) {
                start = i;
            }
            
            if (intervals.get(i).start <= newInterval.end && intervals.get(i).end >= newInterval.end) {
                newInterval.end = intervals.get(i).end;
                end = i;
            }
            
            if (end == intervals.size() - 1 && newInterval.end < intervals.get(i).end) {
                end = i-1;
            }
        }
        
        for (int k = 0; k < end - start + 1; ++k) {
            intervals.remove(start);
        }
        
        intervals.add(start, newInterval);
        
        return intervals;
    }
}
