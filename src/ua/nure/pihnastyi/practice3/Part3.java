package ua.nure.pihnastyi.practice3;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    //    public static final String REGEX = "([A-Za-zA-Яа-яЁёІіЇї])([A-Za-zA-Яа-яЁёІіЇї]+\\s|\\s|[A-Za-zA-Яа-яЁёІіЇї]+$)";
//    public static final String REGEX = "([A-Za-zA-Яа-я])([A-Za-zA-Яа-я]{2,}\\,?\\s+|[A-Za-zA-Яа-я]+$)";
    public static final String REGEX = "([A-Za-zA-Яа-я])([A-Za-zA-Яа-я]{2,}\\,?\\s+|[A-Za-zA-Яа-я]+$)";


    public static void main(String[] args) {
        String input = Util.readFile("part3.txt");
        System.out.println(Part3.convert(input));
    }

    private static String convert(String input) {

        String result;
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher m = pattern.matcher(input);

        sb.append(input);
        while (m.find()) {

            sb.replace(m.start(1), m.end(1), m.group(1).toUpperCase());
        }

        result = sb.toString();
        return result;
    }
}