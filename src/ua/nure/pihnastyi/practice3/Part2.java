package ua.nure.pihnastyi.practice3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static final String REGEX = "[A-Za-zA-Яа-яЁёІіЇї]+";


    public static void main(String[] args) {
        String input = Util.readFile("part2.txt");
        System.out.println(Part2.convert(input));
    }


    public static String convert(String input) {
        List<String> minSizeWord = new ArrayList<>();
        List<String> maxSizeWord = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String result;
        Pattern pattern = Pattern.compile(REGEX);
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            maxSizeWord.add(m.group());
            minSizeWord.add(m.group());
        }

        while (m.find()) {

            if (m.group().length() > maxSizeWord.get(0).length()) {
                maxSizeWord.clear();
                maxSizeWord.add(m.group());
            }
            if (m.group().length() == maxSizeWord.get(0).length() && !maxSizeWord.contains(m.group())) {
                maxSizeWord.add(m.group());
            }
            if (m.group().length() < minSizeWord.get(0).length()) {
                minSizeWord.clear();
                minSizeWord.add(m.group());
            }
            if (m.group().length() == minSizeWord.get(0).length() && !minSizeWord.contains(m.group())) {
                minSizeWord.add(m.group());
            }


        }

        sb.append("Min: ");
        for (String s : minSizeWord) {
            sb.append(s).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(System.lineSeparator());
        sb.append("Max: ");
        for (String s : maxSizeWord) {
            sb.append(s).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(System.lineSeparator());
        result = sb.toString();
        return result;
    }
}