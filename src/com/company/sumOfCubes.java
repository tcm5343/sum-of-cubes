package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
            int[] allCubeRoots = findCBRTs(num); // assigns cube roots to a list
            int[] cubes = new int[9];



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
            // checks if the cbrt is an integer
            if (Math.cbrt((double) i) % 1 == 0) {
                return (int) Math.cbrt(i);
            }
        } // end of for loop
        return 1;
    }

    // returns an array which all whole CBRTs fit into
    private static int[] findCBRTs(int num) {
        int CBRTcount = getCBRTcount(num); // returns the number of whole cube roots within the number
        int[] array = new int[CBRTcount];
        for (int i = 0; i <= array.length-1; i++) { // fills array with incrementing numbers
            array[i] = i+1;
            }
        return array;
    }

    // returns how many cube roots are in a number
    private static int getCBRTcount(int num) {
        int count = 0;
        for (int j = 1; j <= num; j++) {
            if (Math.pow(j, 3) <= num) {
                count++;
            }
        }
        // checks highest digit
        if (count == 0) { return 1; }
        else { return count; }
    }

}