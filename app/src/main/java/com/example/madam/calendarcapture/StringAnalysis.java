package com.example.madam.calendarcapture;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Max Zhu on 2018-02-26.
 */

public class StringAnalysis {

    static private final String m[] = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    static private final List<String> months = Arrays.asList(m);

    static String filterAlphaNum(String s) {
        String out = "";
        for (int i = 0; i < s.length(); i++) {
            out += (s.charAt(i) == ' ' || Character.isLetterOrDigit(s.charAt(i)))
                    ? s.charAt(i) : "";
        }
        return out;
    }

    public static String extractDate(String s) {
        String alphaNum = StringAnalysis.filterAlphaNum(s);
        StringTokenizer st = new StringTokenizer(alphaNum);
        String date = "";

        while (st.hasMoreTokens()) {
            String next = st.nextToken();

            try {
                if (months.contains(next) || (0 < Integer.parseInt(next) && Integer.parseInt(next) < 32)) {
                    date += next + " ";
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return date;
    }
}
