package com.amakhnev.problems.interviewbit.stacksandqueues;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        System.out.println("Result = " + new SlidingWindowMaximum().slidingMaximum(
                Arrays.asList(5, 4, 3, 2, 1, 1, 1, 2, 1, 3), 3
        ));

    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> maxIndex = new LinkedList<>();

        for (int i = 0; i < A.size(); i++) {
            // remove all values less than current value
            while (!maxIndex.isEmpty() && A.get(maxIndex.peekFirst()) <= A.get(i)) {
                maxIndex.removeFirst();
            }

            // adding to the beginning of the list as it's a new minimum
            maxIndex.addFirst(i);

            if (i >= B - 1) { // before B-i just collecting information
                result.add(A.get(maxIndex.peekLast()));
                if (maxIndex.peekLast() <= i - B + 1) { // remove if index is on beginning of window
                    maxIndex.removeLast();
                }
            }
        }

        return result;

    }
}
