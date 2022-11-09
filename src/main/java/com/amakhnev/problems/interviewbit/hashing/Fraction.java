package com.amakhnev.problems.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class Fraction {

    public static void main(String[] args) {
        System.out.println(new Fraction().fractionToDecimal(1, 2147483647));
    }


    public String fractionToDecimal(int A, int B) {
        int sign = Integer.signum(A) * Integer.signum(B);
        long longA = Math.abs((long) A);
        long longB = Math.abs((long) B);
        StringBuilder sb = new StringBuilder();
        if (sign < 0) {
            sb.append('-');
        }
        sb.append(longA / longB);
        long reminder = longA % longB;
        if (reminder == 0) {
            return sb.toString();
        }
        ArrayList<Long> values = new ArrayList<>();
        int counter = 0;
        HashMap<Long, Integer> reminders = new HashMap<>();
        sb.append('.');
        while (true) {
            reminder *= 10;
            if (reminder == 0) {
                for (long num : values) {
                    sb.append(num);
                }
                return sb.toString();
            }

            if (reminders.containsKey(reminder)) {
                int start = sb.length();
                for (long num : values) {
                    sb.append(num);
                }
                sb.insert(start + reminders.get(reminder), '(');
                sb.append(')');
                return sb.toString();

            }

            values.add(reminder / longB);
            reminders.put(reminder, counter++);
            reminder = reminder % longB;

        }

    }
}
