package com.amakhnev.problems.interviewbit.stacksandqueues;

import java.util.*;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println("Result = " + new LargestRectangleInHistogram().largestRectangleArea(
                new ArrayList<>(Arrays.asList(3, 0, 5, 4, 5, 1, 0, 1))
        ));

    }


    public int largestRectangleArea(ArrayList<Integer> A) {

        int maxArea = Integer.MIN_VALUE;
        // each pair represents a rectangle, with starting index in first position and max height in second. Rectangles with smaller index go first!
        List<int[]> rectangles = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) { // invalidate all rectangles
                rectangles = new ArrayList<>();
                continue;
            }

            int maxHeight = Integer.MIN_VALUE;
            for (Iterator<int[]> it = rectangles.iterator(); it.hasNext(); ) {
                int[] rectangle = it.next();
                int newHeight = Math.min(A.get(i), rectangle[1]);
                if (newHeight > maxHeight) {
                    rectangle[1] = newHeight;
                    maxHeight = Math.max(maxHeight, newHeight);
                    maxArea = Math.max(maxArea, (i - rectangle[0] + 1) * newHeight);
                } else { // delete as appears there is bigger rectangle exists before
                    it.remove();
                }
            }
            if (A.get(i) > maxHeight) { // only add if can potentially be new max
                maxArea = Math.max(maxArea, A.get(i));
                rectangles.add(new int[]{i, A.get(i)});
            }
        }


        return maxArea;
    }

}
