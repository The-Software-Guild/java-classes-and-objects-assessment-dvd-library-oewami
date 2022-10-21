package ui;

import java.util.Scanner;

public class UserIO implements ReadableIO {

    final private Scanner scanner = new Scanner(System.in);

    /**
     * Outputs a message to the console
     * @param message message to be displayed
     */
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    /**
     * Outputs a message to the console. Takes input from console.
     *
     * @param prompt message displayed to the console
     * @return The user's input
     */
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
