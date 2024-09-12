package services;

import java.util.Scanner;

public class CLI {
    private static CLI cli;
    private CLI() {};
    
    public static synchronized CLI getCli() {
        if(cli == null) {
            cli = new CLI();
        }
        return cli;
    }
    public void display(String s) {
        System.err.println(s);
    }
    public String takeInput(String s) {
        Scanner scan = new Scanner(System.in);
        this.display(s);
        String input = scan.nextLine();
        scan.close();
        return input;
    }
}
