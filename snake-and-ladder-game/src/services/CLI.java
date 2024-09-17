package services;

import java.util.Scanner;

public class CLI {
    private static CLI cli;
    private Scanner scan;

    private CLI() {
        scan = new Scanner(System.in);
    }

    public static synchronized CLI getCli() {
        if (cli == null) {
            cli = new CLI();
        }
        return cli;
    }

    public void display(String s) {
        System.err.println(s);
    }

    public String takeInput(String s) {
        this.display(s);
        String input = this.scan.nextLine();
        return input;
    }

    public void close() {
        if (scan != null) {
            scan.close();
        }
    }
}
