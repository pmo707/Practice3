package ua.nure.pihnastyi.practice3;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    private static final int RANDOM_FROM = 1000;
    private static final int RANDOM_TO = 10000;
    private static final int GROUP_ONE = 1;
    private static final int GROUP_TWO = 2;
    private static final int GROUP_THREE = 3;
    private static final int GROUP_FOUR = 4;
    public static final int LAST_TWO_ELM = 2;

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
            sb.append(m.group(GROUP_ONE)).append(" ==> ").append(m.group(GROUP_THREE))
                    .append("@").append(m.group(GROUP_FOUR))
                    .append(System.lineSeparator());
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
            sb.append(m.group(GROUP_THREE)).append(" " + m.group(GROUP_TWO))
                    .append(" (email: ").append(m.group(GROUP_FOUR)).append(")")
                    .append(System.lineSeparator());
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
            if (!mails.contains(m.group(GROUP_FOUR))) {
                mails.add(m.group(GROUP_FOUR));
            }
        }
        for (int i = 0; i < mails.size(); i++) {
            m.reset();
            sb.append(mails.get(i)).append(" ==> ");
            while (m.find()) {
                if (mails.get(i).equals(m.group(GROUP_FOUR))) {
                    sb = sb.append(m.group(GROUP_ONE)).append(", ");
                }
            }
            sb.delete(sb.length() - LAST_TWO_ELM, sb.length());
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
            Random r = new SecureRandom();
            int range = RANDOM_TO - RANDOM_FROM;
            int rand = r.nextInt(range);
            int randomNumber = rand + RANDOM_FROM;
            sb = sb.append(m.group()).append(";").append(randomNumber).append(System.lineSeparator());
        }

        result = sb.toString();
        return result;
    }
}