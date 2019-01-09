package ua.nure.pihnastyi.practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static final String REGEX = "(?m)^(.+);(.+);(.+)@(.+)$";
    public static final String REGEX2 = "(?m)^(.+);(.+) (.+);(.+)$";
    public static final String REGEX3 = "(?m)^(.+);(.+);(.+)$";


    public static void main(String[] args) {
        String input = Util.readFile("part1.txt");

        System.out.println(Part1.convert1(input));
        System.out.println(Part1.convert2(input));
        System.out.println(Part1.convert3(input));
        System.out.println(Part1.convert4(input));
    }


    public static String convert1(String input) {
        String result;
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher m = pattern.matcher(input);
        while (m.find()) {
            sb.append(m.group(1)).append(" ==> ").append(m.group(3)).append("@").append(m.group(4)).append(System.lineSeparator());
        }
        result = sb.toString();
        return result;

    }

    private static String convert2(String input) {

        String result;
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX2);
        Matcher m = pattern.matcher(input);
        while (m.find()) {
            sb.append(m.group(3)).append(" " + m.group(2)).append(" (email: ").append(m.group(4)).append (")").append(System.lineSeparator());
        }
        result = sb.toString();
        return result;
    }

    private static String convert3(String input) {
        String result;
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher m = pattern.matcher(input);
        List<String> mails = new ArrayList<>();
        while (m.find()) {
            if (!mails.contains(m.group(4))) {
                mails.add(m.group(4));
            }
        }
        for (int i = 0; i < mails.size(); i++) {
            m.reset();
            sb.append(mails.get(i)).append(" ==> ");
            while (m.find()) {
                if (mails.get(i).equals(m.group(4))) {
                    sb = sb.append(m.group(1)).append(", ");
                }
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append(System.lineSeparator());
        }

        result = sb.toString();
        return result;
    }

    private static String convert4(String input) {

        String result;
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX3);
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            sb = sb.append(m.group()).append(";Password").append(System.lineSeparator());
        }
        while (m.find()) {
            int a = 1000;
            int b = 10000;
            int range = b - a;
            int random_number = a + (int) (Math.random() * range);
            sb = sb.append(m.group()).append(";").append(random_number).append(System.lineSeparator());
        }

        result = sb.toString();
        return result;
    }
}