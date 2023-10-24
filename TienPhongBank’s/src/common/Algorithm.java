package common;

import java.util.Locale;

public class Algorithm {

    Library library = new Library();

    public char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};

    public String generateCaptchaText() {
        String randomStrValue = "";
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length));
            sb.append(chars[index]);
        }
        return sb.toString();
    }

    public void login(Locale language) {
        library.getWordLanguage(language, "enterAccountNumber");
        int accountNumber = library.checkInputAccount(language);
        library.getWordLanguage(language, "enterPassword");
        String passString = library.checkInputPassword(language);
        String captchaGenerated = generateCaptchaText();
        while (true) {
            if (library.checkInputCaptcha(captchaGenerated, language)) {
                library.getWordLanguage(language, "loginSuccess");
                System.out.println();
                return;
            } else {
                library.getWordLanguage(language, "errCaptchaIncorrect");
                System.out.println();
            }
        }
    }

}