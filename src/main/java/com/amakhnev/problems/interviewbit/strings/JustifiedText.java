package com.amakhnev.problems.interviewbit.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class JustifiedText {

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(Arrays.asList("This", "is", "an", "example", "of", "text", "justification."));

        System.out.println("Result = " + new JustifiedText().fullJustify(input, 16));

    }


    public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        int tempLength = 0;

        for (String str : A) {
            if (tempLength + temp.size() + str.length() > B) {
                if (temp.size() > 0) {
                    result.add(justify(temp, tempLength, B, false));
                    temp.clear();
                    tempLength = 0;
                }
            }
            temp.add(str);
            tempLength += str.length();
        }
        if (temp.size() > 0) {
            result.add(justify(temp, tempLength, B, true));
        }
        return result;
    }


    public static String justify(ArrayList<String> input, int inputLength, int maxLength, boolean leftJustify) {
        StringBuilder sb = new StringBuilder();
        char[] spaces;
        if (input.size() == 1 || leftJustify) {
            for (int i = 0; i < input.size(); i++) {
                sb.append(input.get(i));
                if (i < input.size() - 1) {
                    sb.append(' ');
                }
            }

            int padLeft = maxLength - inputLength - input.size() + 1;
            if (padLeft > 0) {
                spaces = new char[padLeft];
                Arrays.fill(spaces, ' ');
                sb.append(spaces);
            }

        } else {
            int numOfSpaces = (maxLength - inputLength) / (input.size() - 1);
            int firstAdd = (maxLength - inputLength) % (input.size() - 1);
            for (int i = 0; i < input.size(); i++) {
                sb.append(input.get(i));
                if (i < input.size() - 1) {
                    spaces = new char[numOfSpaces + ((i < firstAdd) ? 1 : 0)];
                    Arrays.fill(spaces, ' ');
                    sb.append(spaces);
                }
            }
        }
        return sb.toString();
    }

}
