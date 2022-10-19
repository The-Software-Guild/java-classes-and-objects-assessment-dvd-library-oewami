package ui;

import java.util.Scanner;

public class UserIO implements ReadableIO {

    final private Scanner scanner = new Scanner(System.in);
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String nextLine(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }

    public void closeScanner() {
        scanner.close();
    }
}
