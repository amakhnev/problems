package com.amakhnev.problems.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class WordsFinder {


    public static void main(String[] args) throws IOException {


        FastScanner in = new FastScanner(Thread.currentThread().getContextClassLoader().getResourceAsStream("WarAndPeace.txt"));
        WordsNode storage = new WordsNode();
        int i = 0;

        for (String sd = in.next(); sd != null; sd = in.next()) {
            sd = strip(sd);
            if (sd.length() > 0) {
                storage.addWord(sd);
                i++;
            }
        }
        int matchedCount = 0;
        in = new FastScanner(Thread.currentThread().getContextClassLoader().getResourceAsStream("AliceInWonderland.txt"));
        Set<String> unmatched = new HashSet<>();
        for (String sd = in.next(); sd != null; sd = in.next()) {
            sd = strip(sd);
            if (sd.length() > 0) {
                if (storage.hasWord(sd)) {
                    matchedCount++;
                } else {
                    if (!unmatched.contains(sd))
                        unmatched.add(sd);
                }
            }
        }

        System.out.println("Total number of words in dictionary = " + i);
        System.out.println("Matched count = " + matchedCount);
        System.out.println("Unmatched count = " + unmatched.size());

    }

    /**
     * funcion removes . , ; : from the string and all non word characters from the beginning of the string
     */
    private static String strip(String str) {
        str = str.replaceAll("[\\.,:;/!?\"_()]", "").toLowerCase();
        while (str.length() > 0 && !str.substring(0, 1).matches("[a-z]")) {
            str = str.substring(1);
        }
        return str;
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = reader.readLine();
                if (line == null) {
                    return null;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }

    }
}
