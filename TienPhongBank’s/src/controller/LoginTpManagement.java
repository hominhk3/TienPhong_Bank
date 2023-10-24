package controller;

import common.Library;
import common.Algorithm;
import java.util.Locale;
import view.Menu;

public class LoginTpManagement extends Menu<String> {

    static String[] mc = {"Vietnamese", "English", "Exit"};

    protected Library library;
    protected Algorithm algorithm;

    Locale vietnamese = new Locale("vi");
    Locale english = Locale.ENGLISH;

    public LoginTpManagement() {
        super("====== Login Program ======", mc);
        library = new Library();
        algorithm = new Algorithm();

    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                algorithm.login(vietnamese);
                break;
            case 2:
                algorithm.login(english);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Your choice invalid! Pls input another choice");
        }
    }
}
