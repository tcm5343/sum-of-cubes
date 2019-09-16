package com.company;

import java.util.Scanner;

/***************
 Author: @tcm5343
 ***************/

public class sumOfCubes {

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a positive integer: ");
            int num = Math.abs(input.nextInt());

            // insert loop (call to function) here

            System.out.println("Program is finished");
            System.exit(0);

        } catch (Exception e) {
            System.out.println("Error: Invalid Input");
            main(args);
        }
    }

    // returns the highest cube root (first cube root it finds is divisible)
// starting from the input and decrementing
    private static int getDecrementingCBRT(int num) {
        // starts at the num and decrements until it finds a cbrt
        for (int i = num; i >= 0; i--) {
            double temp = (double) i;
            // checks if the cbrt is an integer
            if (Math.cbrt(temp) % 1 == 0) {
                return (int) Math.cbrt(temp);
            }
        } // end of for loop
        return 1;
    }

    // returns the highest cube root starting from 1 to the number
// very slow
    private static int getIncrementingCBRT(int num) {
        int highest = 0;
        for (int j = 1; j <= num; j++) {
            if (Math.pow(j, 3) <= num) {
                highest = j;
            }
        }
        // checks highest digit
        if (highest == 0) {
            return 1;
        } else {
            return highest;
        }
    }
}