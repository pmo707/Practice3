package ua.nure.pihnastyi.practice3;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

    public static final int DECIMAL=10;

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
            if (x >= 9 * value) {
                sb.append(number2String(value)).append(number2String(value * 10));
                x = x - 9 * value;
            } else if (x >= 5 * value) {
                sb.append(number2String(5 * value));
                x = x - 5 * value;
            } else if (x >= 4 * value) {
                sb.append(number2String(value)).append(number2String(value * 5));
                x = x - 4 * value;
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
        switch (x) {
            case 1:
                return "I";

            case 5:
                return "V";

            case 10:
                return "X";

            case 50:
                return "L";

            case 100:
                return "C";

            default:
                return "not found";
        }
    }

    public static int string2Number(String x) {
        switch (x) {
            case "I":
                return 1;

            case "V":
                return 5;

            case "X":
                return 10;

            case "L":
                return 50;

            case "C":
                return 100;

            default:
                return 0;
        }
    }

    public static void main(String[] strings) {
        for (int i = 1; i <= 100; i++) {
            String numberRoman = decimal2Roman(i);
            System.out.print(i + " ===> ");
            System.out.print(numberRoman + " ===> ");
            System.out.println(roman2Decimal(numberRoman));

        }
    }
}
