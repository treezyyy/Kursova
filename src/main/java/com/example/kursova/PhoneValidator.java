package com.example.kursova;
import java.util.regex.Pattern;

public class PhoneValidator {
    private static final String PHONE_REGEX = "^\\+7[0-9]{10}$";

    public static boolean isValidEmail(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        return pattern.matcher(phone).matches();
    }
}