package com.company;

import java.util.Scanner;

                                                /***************
                                                Author: @tcm5343
                                                ***************/

public class Main {

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a positive integer: ");
            long num = Math.abs(input.nextLong());
            int sum = 0;
            long remainder = num;

            for (int i = 1; i <= 9; i++) { // 9 is the limit of cubes in LE Dickson's proof

                System.out.println(i + " cube: " + getCBRT(remainder));

                double cube = Math.pow(getCBRT(remainder), 3); // cubes the cbrt
                sum += cube; // adds the cube to the sum
                remainder -= cube; // subtracts the cube from the sum

                if (sum == num) { break; } // checks if sum equals original number
            }
            System.out.println("Sum: " + sum);
        } catch (Exception e) {
            System.out.println("Error: Invalid Input");
            main(args);
        }
    }

    private static long getCBRT(long num) {

        int highest = 0;

        // loop finds highest square root in the number and returns it
        // this is very inefficient for large numbers but it works for now
        // todo run test to see if decrementing and doing Math.cbrt() is faster?
            for (int j = 1; j <= num; j++) {
                if (Math.pow(j, 3) <= num) {
                    highest = j;
                }
            }
            // checks highest digit
            if (highest == 0) { return 1; }
            else { return highest; }
    }
}
