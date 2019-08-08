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
            int num = Math.abs(input.nextInt());
            int sum = 0;
            int remainder = num;

            for (int i = 1; i <= 9; i++) { // 9 is the limit of cubes in LE Dickson's proof

                System.out.print(getCBRT(remainder) + " cubed");

                double cube = Math.pow(getCBRT(remainder), 3); // cubes the cbrt
                sum += cube; // adds the cube to the sum
                remainder -= cube; // subtracts the cube from the sum

                if (sum == num) { break; } // checks if sum equals original number
                else {  System.out.print(" + "); } // checks to see if a + is needed
            }
            System.out.println();
            System.out.println("Sum of cubes: " + sum);
        } catch (Exception e) {
            System.out.println("Error: Invalid Input");
            main(args);
        }
    }

    private static int getCBRT(int num) {

        int highest = 0;

        // starts at the num and decrements until it finds a cbrt
            for (int i = num; i >= 0; i--) {
                double temp = (double)i;
                // checks if the cbrt is an integer
                if (Math.cbrt(temp) % 1 == 0) {
                    return (int)Math.cbrt(temp); }
                else { highest = 1; }
            }
            return highest;
    }
}


// this loop increments by one finding the highest square root
// very inefficient for large numbers but saving the code for reference

/*for (int j = 1; j <= num; j++) {
        if (Math.pow(j, 3) <= num) {
        highest = j; } }
        // checks highest digit
        if (highest == 0) { return 1; }
        else { return highest; }*/
