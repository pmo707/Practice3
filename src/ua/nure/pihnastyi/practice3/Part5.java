package ua.nure.pihnastyi.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {


    public static String decimal2Roman(int x) {

        StringBuilder tmp = new StringBuilder();
        while (x > 0) {
            int base = 0;
            if ((x >= 1) && (x <= 9))
                base = 1;
            else if ((x >= 10) && (x <= 99))
                base = 10;
            else if ((x >= 100) && (x <= 999))
                base = 100;
            else if ((x >= 1000) && (x <= 3999))
                base = 1000;
            else if (x >= 4000) {
                return "error";
            }
            if (x >= 9 * base) {
                tmp.append(number2String(base)).append(number2String(base * 10));
                x = x - 9 * base;
            } else if (x >= 5 * base) {
                tmp.append(number2String(5 * base));
                x = x - 5 * base;
            } else if (x >= 4 * base) {
                tmp.append(number2String(base)).append(number2String(base * 5));
                x = x - 4 * base;
            }
            while (x >= base) {
                tmp.append(number2String(base));
                x = x - base;
            }
        }

        return tmp.toString();
    }


    public static void roman2Decimal(String s) {
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
        System.out.println(result);
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
    roman2Decimal("XIV");
    }
}
