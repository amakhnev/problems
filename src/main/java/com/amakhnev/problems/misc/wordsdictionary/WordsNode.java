package com.amakhnev.problems.misc.wordsdictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsNode {
    Node root;

    public WordsNode() {
        root = new Node('0');
    }

    public void addWord(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.addChild(word.charAt(i), word.length() - 1 - i == 0);
        }
    }

    public boolean hasWord(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.leafCount > 0;
    }

    protected class Node {

        char value;
        int leafCount = 0;
        Map<Character, Node> children;

        public Node(char value, int leafCount) {
            this.value = value;
            this.leafCount = leafCount;
            this.children = new HashMap<>();
        }

        public Node(char value) {
            this(value, 0);
        }


        public Node addChild(char child, boolean addLeafCount) {
            if (children.containsKey(child)) {
                if (addLeafCount) {
                    children.get(child).leafCount++;
                }
            } else {
                children.put(child, new Node(child, addLeafCount ? 1 : 0));
            }
            return children.get(child);
        }


    }
}
