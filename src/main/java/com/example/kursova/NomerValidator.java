package com.example.kursova;
import java.util.regex.Pattern;

public class NomerValidator {
    private static final String NOMER_REGEX = "[а-я]\\d{3}[а-я]{2}\\d{2,3}";

    public static boolean isValidNomer(String nomerg) {
        System.out.println(nomerg);
        Pattern pattern = Pattern.compile(NOMER_REGEX);
        System.out.println(pattern);
        return pattern.matcher(nomerg).matches();
    }
}