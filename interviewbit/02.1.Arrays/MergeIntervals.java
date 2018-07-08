import java.util.ArrayList;

public class MergeIntervals {

    public static void main(String[] args) {
        Interval newInterval = new Interval(9,30);
        ArrayList<Interval> intervals = new ArrayList<>();
       intervals.add(new Interval(1,2));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,17));
        intervals.add(new Interval(19,33));
        intervals.add(new Interval(38,40));


        System.out.println("intervals = " + new MergeIntervals().insert(intervals,newInterval));
    }


    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<>();

        int lastIdx = -1,firstStart = Integer.MAX_VALUE,lastEnd = Integer.MIN_VALUE;

        for(Interval interval:intervals){
            if (interval.start<=newInterval.end && interval.end>=newInterval.start){

                firstStart = Math.min(firstStart,interval.start);
                lastEnd = interval.end;
            }else{
                if (interval.end<newInterval.start){
                    lastIdx = intervals.indexOf(interval);
                }
                result.add(interval);
            }
        }

        int start = Math.min(firstStart,newInterval.start);
        int end = Math.max(lastEnd,newInterval.end);

        result.add(lastIdx+1, new Interval(start, end));

        return result;
    }
}
