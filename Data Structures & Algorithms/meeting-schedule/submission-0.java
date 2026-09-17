/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();

        Collections.sort(intervals , Comparator.comparingInt(i -> i.start));

        for(int i=1 ; i<n ; i++){
            Interval meet1 = intervals.get(i-1);
            Interval meet2 = intervals.get(i);

            if(meet2.start<meet1.end){
                return false;
            }
        }

        return true;
    }
}
