// Matthew Valencia 

// CS 145 Lab 6 Recursion 

// May 21st 

// Youtube, W3 Schools
// for extra credit I did both the Pascals Triangle and the Least Common Demoniator for this lab

import java.util.Scanner;

public class LeastCommonDenominator {

    // Method to calculate the Greatest Common Divisor (GCD) using recursion
    public static int gcd(int a, int b) {
        // Base case: if b is 0, return a as the GCD
        if (b == 0) {
            return a;
        }
        // Recursive call: gcd(b, a % b)
        return gcd(b, a % b);
    }

    // Method to calculate the Least Common Multiple (LCM) using the GCD
    public static int lcm(int a, int b) {
        // LCM is calculated using the formula: |a * b| / gcd(a, b)
        return Math.abs(a * b) / gcd(a, b);
    }

    // Method to parse the fraction input and extract the numerator and denominator
    public static int[] parseFraction(String fraction) {
        // Split the fraction string into two parts based on the "/" delimiter
        String[] parts = fraction.split("/");
        // Parse the numerator and denominator as integers
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        // Return the numerator and denominator as an array
        return new int[]{numerator, denominator};
    }

    // Main method to test the Least Common Denominator (LCD) calculation
    public static void main(String[] args) {
        // Create a Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first fraction
        System.out.println("Enter the first fraction (e.g., 1/2): ");
        // Read the first fraction input from the user
        String fraction1 = scanner.nextLine();
        // Parse the first fraction to get the numerator and denominator
        int[] fraction1Parts = parseFraction(fraction1);
        int num1 = fraction1Parts[0];
        int den1 = fraction1Parts[1];

        // Prompt the user to enter the second fraction
        System.out.println("Enter the second fraction (e.g., 4/5): ");
        // Read the second fraction input from the user
        String fraction2 = scanner.nextLine();
        // Parse the second fraction to get the numerator and denominator
        int[] fraction2Parts = parseFraction(fraction2);
        int num2 = fraction2Parts[0];
        int den2 = fraction2Parts[1];

        // Calculate the Least Common Denominator (LCD) of the two fractions
        int lcd = lcm(den1, den2);

        // Output the result to the user
        System.out.println("The Least Common Denominator of fractions " + num1 + "/" + den1 + " and " + num2 + "/" + den2 + " is: " + lcd);
        
        // Close the scanner to free up resources
        scanner.close();
    }
}



