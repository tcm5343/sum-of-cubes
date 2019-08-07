package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a number: ");

            double num = input.nextDouble();
            int sum = 0;

            for (int i = 0; i < 9; i++) {
                int highest = 0;
                for (int j = 0; j < num; j++) {

                    if (Math.cbrt(num) % j == 0) {
                        highest = j;
                    }
                }

                if (highest == 0) {
                    highest = 1;
                }

                System.out.print(highest + " cubed + ");
                sum += highest;
                num = highest;

            } // end of outer for
            System.out.println("Sum: " + sum);
        } catch (Exception e) {
            System.out.println("Error: Invalid Input");
        }

    }
}
