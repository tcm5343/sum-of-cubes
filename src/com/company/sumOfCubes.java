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
            int count = 1;

            Boolean test = function(num, getCBRT(num));

            // while (!function(num, (int)Math.pow(getCBRT(num),3))) { // if the function returns false
            while (!test) { // while the function returns false
                int highestCBRT = getCBRT(num);
                if (highestCBRT - count != 0) {
                    test = function(num, highestCBRT - count);
                    count++;
                }
                else {
                    System.out.println("This program has failed to produce the correct result");
                    System.exit(0);
                }
            }

            System.out.println("Program is finished");
            System.exit(0);

        } catch (Exception e) {
            System.out.println("Error: Invalid Input");
            main(args);
        }
    }

    private static Boolean function(int num, int highestCBRT) {
        int sum = 0;
        int remainder = num;
        int count = 0;
        double cube;
        boolean proof = false;

        while (sum != num) {

            if (highestCBRT != getCBRT(num)) {
                System.out.print(highestCBRT + " cubed (" + (int) Math.pow(highestCBRT, 3) + ") + ");

                cube = Math.pow(highestCBRT, 3); // cubes the cbrt
                sum += cube; // adds the cube to the sum
                remainder -= cube; // finds the remainder
                count++; // count must be less than or equal to 9 to prove the theory
            }

            cube = Math.pow(getCBRT(remainder), 3); // cubes the cbrt
            System.out.print(getCBRT(remainder) + " cubed (" + (int)Math.pow(getCBRT(remainder),3) + ")");

            sum += cube; // adds the cube to the sum
            remainder -= cube; // finds the remainder
            count++; // count must be less than or equal to 9 to prove the theory

            if (sum == num || count >= 9) {
                break;
            } // checks if sum equals original number
            else {
                System.out.print(" + ");
            } // checks to see if a + is needed

        }

        if (count <= 9 && sum == num) {
            proof = true;
        }

        System.out.println();
        System.out.println("Sum of cubes: " + sum);
        if (proof) {
            System.out.println("This proves LE Dickson's Theory");
            return true;
        } else {
            System.out.println("This does not prove LE Dickson's Theory");
            return false;
        }
    }

    private static int getCBRT(int num) {
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
}


// this loop increments by one finding the highest square root
// very inefficient for large numbers but saving the code for reference

/*for (int j = 1; j <= num; j++) {
        if (Math.pow(j, 3) <= num) {
        highest = j; } }
        // checks highest digit
        if (highest == 0) { return 1; }
        else { return highest; }*/
