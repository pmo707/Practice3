package ua.nure.pihnastyi.practice3;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.Locale;


public class Part4 {

    public static String hash(String input, String hashType) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(hashType);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        StringBuilder sb = new StringBuilder();


        for (byte hashes : hash) {

            if (hashes >= 0&&hashes<10) {

                sb.append("0").append(Integer.toHexString(hashes).toUpperCase(Locale.ENGLISH));
            }
            if (hashes >= 10) {

                sb.append(Integer.toHexString(hashes).toUpperCase(Locale.ENGLISH));
            }
            if (hashes < 0) {
                sb.append(Integer.toHexString(hashes)
                        .substring(Integer.toHexString(hashes).length() - 2).toUpperCase(Locale.ENGLISH));
            }


        }

        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("asd", "SHA-256"));
        System.out.println(hash("asdf", "SHA-256"));
    }
}