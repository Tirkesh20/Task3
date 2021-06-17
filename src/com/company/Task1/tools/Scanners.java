package com.company.Task1.tools;

import java.util.Scanner;

public class Scanners {
    private static final Scanner scanner=new Scanner(System.in);


    public static int intScanner() {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
        return  scanner.nextInt();
    }
}
