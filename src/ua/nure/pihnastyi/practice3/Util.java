package ua.nure.pihnastyi.practice3;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Util {

    private static final String ENCODING = "UTF-8";

    public static String readFile(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(readFile("part2.txt"));
    }

}