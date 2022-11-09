package com.amakhnev.problems.interviewbit.treedatastructure;

import java.util.*;

public class HotelReviewsTries {


    public static void main(String[] args) {


        System.out.println(new HotelReviewsTries().solve(
                "cool_ice_wifi", new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"))
        ));
    }


    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        Trie dictionary = new Trie();
        for (String good : A.split("_")) {
            dictionary.insert(good);
        }

        ArrayList<Map.Entry<Integer, Integer>> arrays = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {
            int count = 0;
            for (String word : B.get(i).split("_")) {
                if (dictionary.find(word)) {
                    count++;
                }
            }
            arrays.add(new AbstractMap.SimpleEntry<>(i, count));
        }

        arrays.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : arrays) {
            result.add(entry.getKey());
        }
        return result;
    }


    public class TrieNode {
        private HashMap<Character, TrieNode> children;
        private boolean isWord;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public void setEndOfWord(boolean b) {
            this.isWord = true;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }


        public boolean isEndOfWord() {
            return isWord;
        }
    }

    public class Trie {
        private TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode current = root;

            for (int i = 0; i < word.length(); i++) {
                current = current.getChildren()
                        .computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            current.setEndOfWord(true);
        }

        public boolean find(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.getChildren().get(ch);
                if (node == null) {
                    return false;
                }
                current = node;
            }
            return current.isEndOfWord();
        }
    }
}
