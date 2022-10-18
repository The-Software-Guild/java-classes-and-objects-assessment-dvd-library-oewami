package ui;

import java.util.Scanner;

public class UserIO implements ReadableIO {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String nextLine(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String input = scanner.nextLine();
        System.out.println(input);
        scanner.close();
        return input;
    }
}
