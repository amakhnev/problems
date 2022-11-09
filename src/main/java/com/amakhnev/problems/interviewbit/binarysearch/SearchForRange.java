package com.amakhnev.problems.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForRange {

    public static void main(String[] args) {
        System.out.println("Result = " + new SearchForRange().searchRange(
                Arrays.asList(1,2,2,3,4,4,5,5),7
        ));
    }

    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int minIdx = binarySearch(a,b,0,a.size(),true);
        int maxIdx = minIdx>=0?binarySearch(a,b,0,a.size(),false):-1;
        return new ArrayList<>(Arrays.asList(minIdx,maxIdx));
    }

    private int binarySearch(List<Integer> a, int b, int left, int right, boolean searchFirst) {
        int result = -1;
        while (left<right){
            int mid = (right + left) /2;
            if (a.get(mid)==b){
                result = mid;
                if (searchFirst){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            else if (a.get(mid)>b){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return result;
    }
}
