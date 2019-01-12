package ua.nure.pihnastyi.practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
    private static final String REGEX = "[A-Za-zA-Яа-яЁёІіЇї]+";
    private static final int LAST_TWO_ELEMENTS = 2;

    public static void main(String[] args) {
        String input = Util.readFile("part2.txt");
        System.out.println(Part2.convert(input));
    }

    private static String convertListToString(List<String> list, String listTitle) {
        StringBuilder sb = new StringBuilder();
        sb.append(listTitle);
        for (String s : list) {
            sb.append(s).append(", ");
        }
        sb.delete(sb.length() - LAST_TWO_ELEMENTS, sb.length());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    public static String convert(String input) {
        List<String> minSizeWords = new ArrayList<>();
        List<String> maxSizeWords = new ArrayList<>();

        Pattern pattern = Pattern.compile(REGEX);
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            maxSizeWords.add(m.group());
            minSizeWords.add(m.group());
        }
        while (m.find()) {
            String matchedWord = m.group();
            int maxWordLength = maxSizeWords.get(0).length();
            int minWordLength = minSizeWords.get(0).length();

            if (matchedWord.length() > maxWordLength) {
                maxSizeWords.clear();
                maxSizeWords.add(matchedWord);
            } else if (matchedWord.length() == maxWordLength && !maxSizeWords.contains(matchedWord)) {
                maxSizeWords.add(matchedWord);
            }
            if (matchedWord.length() < minWordLength) {
                minSizeWords.clear();
                minSizeWords.add(matchedWord);
            } else if (matchedWord.length() == minWordLength && !minSizeWords.contains(matchedWord)) {
                minSizeWords.add(matchedWord);
            }
        }

        return convertListToString(minSizeWords, "Min: ")
                + convertListToString(maxSizeWords, "Max: ");
    }
}