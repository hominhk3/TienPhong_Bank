package common;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Library {

    public Scanner sc = new Scanner(System.in);
    public String ACCOUNT_NUMBER_VALID = "^\\d{10}$";

    public int checkInputIntLimit(int min, int max, Locale language) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                getWordLanguage(language, "errorCheckInputIntLimit");
                System.out.println();
            }
        }
    }

    public String checkInputString(Locale language) {
        while (true) {
            String result = sc.nextLine();
            if (result.length() == 0) {
                getWordLanguage(language, "errCheckInputIntLimit");
                System.out.println();
            } else {
                return result;
            }
        }
    }

    public int checkInputAccount(Locale language) {
        while (true) {
            String result = sc.nextLine();
            if (result.matches(ACCOUNT_NUMBER_VALID)) {
                return Integer.parseInt(result);
            }
            getWordLanguage(language, "errCheckInputAccount");
            System.out.println();
        }
    }

    public String checkInputPassword(Locale language) {
        String result;
        while (true) {
            result = checkInputString(language);
            if (isValidPassword(result, language)) {
                return result;
            }
        }
    }

    public boolean isValidPassword(String password, Locale language) {
        int lengthPassword = password.length();
        if (lengthPassword < 8 || lengthPassword > 31) {
            getWordLanguage(language, "errCheckLengthPassword");
            System.out.println();
            return false;
        } else {
            int countDigit = 0;
            int countLetter = 0;
            for (int i = 0; i < lengthPassword - 1; i++) {
                if (Character.isDigit(password.charAt(i))) {
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {
                    countLetter++;
                }
            }
            if (countDigit < 1 || countLetter < 1) {
                getWordLanguage(language, "errCheckAlphanumericPassword");
                System.out.println();
                return false;
            }
        }
        return true;
    }

    public boolean checkInputCaptcha(String captchaGenerated, Locale language) {
        System.out.println(captchaGenerated);
        getWordLanguage(language, "enterCaptcha");
        String captchaInput = checkInputString(language);
        for (int i = 0; i < captchaInput.length(); i++) {
            if (!captchaGenerated.contains(Character.toString(captchaInput.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public void getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words
                = ResourceBundle.getBundle("Language/" + curLocate, curLocate);
        String value = words.getString(key);
        System.out.printf(value);
    }

    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt);
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

    public void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("");
    }

}