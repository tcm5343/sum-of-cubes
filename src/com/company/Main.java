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

                double temp = num;

                System.out.println((int)getCBRT(num) + " cubed");

                sum += Math.pow(getCBRT(temp), 3); // cubes the cbrt and adds it to the sum
                temp -= Math.pow(getCBRT(temp), 3); // cubes the cbrt and subtracts it from the sum

                if (sum == num) { break; } // ends the loop if sum equals original number
            }

            System.out.println("Sum: " + sum);
        } catch (Exception e) {
            System.out.println("Error: Invalid Input");
        }

    }

    static double getCBRT(double num) {

        int highest = 0;

        for (int i = 1; i <= 9; i++) {

            for (int j = 0; j < num; j++) {
                if (Math.pow(j, 3) <= num) {
                    highest = j;
                }
            }

            if (highest == 0) {
                return 1;
            } else {
                return highest;
            }
        }
        return highest;
    }

}
