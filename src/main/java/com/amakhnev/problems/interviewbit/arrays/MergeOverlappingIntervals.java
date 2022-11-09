package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {

        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(38,41));
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(2,10));
//        intervals.add(new com.amakhnev.problems.interviewbit.arrays.Interval(12,17));
//        intervals.add(new com.amakhnev.problems.interviewbit.arrays.Interval(19,33));
//        intervals.add(new com.amakhnev.problems.interviewbit.arrays.Interval(38,40));


        System.out.println("intervals = " + new MergeOverlappingIntervals().merge(intervals));
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval t1, Interval t2) {
                if (t1.start!=t2.start){
                    return t1.start - t2.start;
                }
                if (t1.end!=t2.end){
                    return t1.end - t2.end;
                }
                return 0;
            }
        });

        int i=0;

        while (i<intervals.size()-1){
            if (intervals.get(i).start<=intervals.get(i+1).end && intervals.get(i).end>=intervals.get(i+1).start){
                intervals.get(i).start = Math.min(intervals.get(i).start,intervals.get(i+1).start);
                intervals.get(i).end = Math.max(intervals.get(i).end,intervals.get(i+1).end);
                intervals.remove(i+1);
            }else{
                i++;
            }
        }

        return intervals;
    }


}
