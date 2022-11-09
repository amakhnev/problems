package com.amakhnev.problems.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,1,5,5,5,5));
        new NextPermutation().nextPermutation(a);
        System.out.println("a = " + a);

    }

    private void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    private void reverse(ArrayList<Integer> a, int left, int right) {
        for (int i = left; i < (left + right) / 2; i++) {
            swap(a, i, right - 1 - i + left);
        }
    }

    public void nextPermutation(ArrayList<Integer> a) {

        if (a.size() < 2) {
            return;
        }

        for (int i = a.size() - 2; i >= 0; i--) {
            // get until we find element which is less than next
            if (a.get(i) < a.get(i + 1)) {
                // find the element which is larger than small element at the end of array to swap
                int j = a.size() - 1;
                while (j > i && a.get(i) >= a.get(j)) {
                    j--;
                }
                swap(a, i, j);

                // sort array i+1 to the end. But it's already sorted (as being non-increasing) so just need to reverse
                reverse(a, i + 1, a.size());

                return;

            }
        }
        //no possible next permutation found, just rearrange array
        reverse(a, 0, a.size());
    }


}
