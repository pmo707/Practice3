package ua.nure.pihnastyi.practice3;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

    private static final int CONVERTED_NUMBERS_SIZE = 100;
    private static final int DECIMAL = 10;
    private static final int ROMAN_I = 1;
    private static final int ROMAN_V = 5;
    private static final int ROMAN_X = 10;
    private static final int ROMAN_L = 50;
    private static final int ROMAN_C = 100;
    private static final String DECIMAL_1_TO_ROMAN = "I";
    private static final String DECIMAL_5_TO_ROMAN = "V";
    private static final String DECIMAL_10_TO_ROMAN = "X";
    private static final String DECIMAL_50_TO_ROMAN = "L";
    private static final String DECIMAL_100_TO_ROMAN = "C";


    public static String decimal2Roman(int x) {
        StringBuilder sb = new StringBuilder();


        while (x > 0) {
            int value = 1;

            int countPow = 0;
            for (int n = x; n != 0; n /= DECIMAL) {
                ++countPow;
            }

            for (int i = 1; i < countPow; i++) {
                value = value * DECIMAL;
            }
            if (x >= (ROMAN_X - 1) * value) {
                sb.append(number2String(value)).append(number2String(value * ROMAN_X));
                x = x - (ROMAN_X - 1) * value;
            } else if (x >= ROMAN_V * value) {
                sb.append(number2String(ROMAN_V * value));
                x = x - ROMAN_V * value;
            } else if (x >= (ROMAN_V - 1) * value) {
                sb.append(number2String(value)).append(number2String(value * ROMAN_V));
                x = x - (ROMAN_V - 1) * value;
            }
            while (x >= value) {
                sb.append(number2String(value));
                x = x - value;
            }
        }


        return sb.toString();
    }


    public static int roman2Decimal(String s) {
        int result = 0;
        Pattern pattern = Pattern.compile("[IVXLC]");
        Matcher m = pattern.matcher(s);
        int a = 0;
        int b = 0;
        int count = 0;
        if (m.find()) {
            a = string2Number(m.group());
            count++;
        }
        while (m.find()) {
            count++;
            b = string2Number(m.group());
            if (a >= b) {
                result = result + a;
                a = b;
            } else {
                result = result - a;
                a = b;
            }
        }
        if (count == 1) {
            result = a;
        }
        if (!m.find()) {
            result = result + b;
        }
        return result;
    }

    public static String number2String(int x) {
        String result;
        switch (x) {
            case ROMAN_I:
                result = DECIMAL_1_TO_ROMAN;
                break;
            case ROMAN_V:
                result = DECIMAL_5_TO_ROMAN;
                break;
            case ROMAN_X:
                result = DECIMAL_10_TO_ROMAN;
                break;
            case ROMAN_L:
                result = DECIMAL_50_TO_ROMAN;
                break;
            case ROMAN_C:
                result = DECIMAL_100_TO_ROMAN;
                break;
            default:
                result = "not found";
                break;
        }
        return result;
    }

    public static int string2Number(String x) {
        int result;
        switch (x) {
            case DECIMAL_1_TO_ROMAN:
                result = ROMAN_I;
                break;
            case DECIMAL_5_TO_ROMAN:
                result = ROMAN_V;
                break;
            case DECIMAL_10_TO_ROMAN:
                result = ROMAN_X;
                break;
            case DECIMAL_50_TO_ROMAN:
                result = ROMAN_L;
                break;
            case DECIMAL_100_TO_ROMAN:
                result = ROMAN_C;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    public static void main(String[] strings) {
        for (int i = 1; i <=CONVERTED_NUMBERS_SIZE; i++) {
            String numberRoman = decimal2Roman(i);
            System.out.print(i + " ===> ");
            System.out.print(numberRoman + " ===> ");
            System.out.println(roman2Decimal(numberRoman));

        }
    }
}
