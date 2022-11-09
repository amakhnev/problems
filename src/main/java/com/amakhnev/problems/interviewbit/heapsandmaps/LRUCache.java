package com.amakhnev.problems.interviewbit.heapsandmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {

    public static void main(String[] args) {
        Solution structure = new LRUCache().new Solution(2);
        structure.set(1,10);
        structure.set(5,12);
        System.out.println(structure.get(5));
        System.out.println(structure.get(1));
        System.out.println(structure.get(10));
        structure.set(6,14);
        System.out.println(structure.get(5));

    }

    public class Solution {

        int capacity;
        ArrayList<Integer> cache;
        HashMap<Integer,Integer> values;

        public Solution(int capacity) {
            this.capacity = capacity;
            cache = new ArrayList<>();
            values = new HashMap<>();
        }

        public int get(int key) {
            if (values.containsKey(key)){
                refreshCache(key);
                return values.get(key);
            }
            return -1;
        }

        private void refreshCache(int key) {
            if (cache.contains(key)){
                cache.remove(new Integer(key));
            }
            cache.add(key);
        }

        public void set(int key, int value) {
            values.put(key,value);
            refreshCache(key);
            if (values.size()>capacity){
                values.remove(cache.get(0));
                cache.remove(0);
            }
        }
    }
}
