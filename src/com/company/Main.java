package com.company;

import java.util.Scanner;

                                                /***************
                                                Author: @tcm5343
                                                ***************/

public class Main {

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a number: ");
            double num = input.nextDouble();
            int sum = 0;
            double remainder = num;

            for (int i = 0; i < 9; i++) {

                System.out.println((int)getCBRT(remainder) + " cubed");

                double cube = Math.pow(getCBRT(remainder), 3); // cubes the cbrt
                sum += cube; // adds the cube to the sum
                remainder -= cube; // subtracts the cube from the sum

                if (sum == num) { break; } // checks if sum equals original number
            }
            System.out.println("Sum: " + sum);
        } catch (Exception e) {
            System.out.println("Error: Invalid Input");
        }
    }

    private static double getCBRT(double num) {
        int highest = 0;

        // loop finds highest square root in the number and returns it
            for (int j = 0; j < num; j++) {
                if (Math.pow(j, 3) <= num) {
                    highest = j;
                }
            }
            // checks highest digit
            if (highest == 0) { return 1; }
            else { return highest; }
    }
}
