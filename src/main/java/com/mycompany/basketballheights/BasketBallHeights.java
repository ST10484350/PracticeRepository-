package com.mycompany.basketballheights;
/**
 *@Cassidy 
 */

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This program prompts the user to enter the heights of basketball team members,
 * then sorts them in descending order using the bubble sort algorithm and displays the result.
 */
public class BasketBallHeights {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int teamSize = 0;
        
// --- User Input for Team Size ---
// Loop until a valid integer is entered.
while (true) {
    try {
        System.out.print("Enter the number of players on the basketball team: ");
        teamSize = input.nextInt();
        if (teamSize > 0) {
            break; // Exit loop if input is a positive integer
        } else {
            System.out.println("Please enter a positive number for the team size.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a whole number.");
        input.next(); // Clear the invalid input from the scanner
    }
}

// --- Array Initialization ---
// Create an array to hold the heights based on the user-defined team size.
double[] heights = new double[teamSize];

// --- User Input for Heights ---
// It requests the user to enter the heights of all the members[cite: 305].
System.out.println("Enter the heights of the " + teamSize + " team members (in cm):");
for (int i = 0; i < heights.length; i++) {
    while (true) {
        try {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
            if (heights[i] > 0) {
                break; // Exit loop if height is valid
            } else {
                System.out.println("Height must be a positive number.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number for the height.");
            input.next(); // Clear invalid input
        }
    }
}

// --- Sorting the Array ---
// The program uses a bubble sort algorithm to sort the heights in descending order[cite: 306].
bubbleSortDescending(heights);

// --- Displaying the Output ---
// The output must display the heights of the team members, one below the other.
System.out.println("\n--- Sorted Team Heights (Descending) ---");
for (int i = 0; i < heights.length; i++) {
    System.out.println("Player " + (i + 1) + ": " + heights[i] + " cm");
}

    input.close(); // Close the scanner to prevent resource leaks
}
    
/**
* Sorts an array of doubles in descending order using the bubble sort algorithm.
* @param arr The array to be sorted.
*/
public static void bubbleSortDescending(double[] arr) {

    int n = arr.length;
// Outer loop for the number of passes
for (int i = 0; i < n - 1; i++) {
    // Inner loop for comparing adjacent elements
    // The loop limit can be optimized to (n - i - 1) as the largest elements are already sorted.
    for (int j = 0; j < n - i - 1; j++) {
        // For descending order, swap if the left element is SMALLER than the right element.
        if (arr[j] < arr[j + 1]) {
            // Swap logic
            double temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
                }
            }
        }
    }
}
