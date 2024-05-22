// Matthew Valencia 

// CS 145 Lab 6 Recursion 

// May 21st 

// Youtube, W3 Schools

// for Extra Credit, I was able to create the Pascals Triangle by actually creating a triangle in the output
// For extra credit I was also able to create this program without any loops 

public class PascalTriangle {

    // Function to generate the nth row of Pascal's Triangle recursively
    public static int[] generateRow(int n) {
        // Base case: the 0th row is just [1]
        if (n == 0) {
            return new int[]{1};
        }

        // Recursive call to generate the (n-1)th row
        int[] previousRow = generateRow(n - 1);
        // Initialize the current row with 1s at both ends
        int[] currentRow = new int[n + 1];
        currentRow[0] = 1;
        currentRow[n] = 1;

        // Fill the current row using the values from the previous row
        fillRow(currentRow, previousRow, 1);
        return currentRow;
    }

    // Helper function to fill the current row based on the previous row
    private static void fillRow(int[] currentRow, int[] previousRow, int index) {
        // Base case: if index reaches the last element, stop recursion
        if (index == currentRow.length - 1) {
            return;
        }
        // Fill the current element with the sum of two elements from the previous row
        currentRow[index] = previousRow[index - 1] + previousRow[index];
        // Recursive call to fill the next element
        fillRow(currentRow, previousRow, index + 1);
    }

    // Function to print Pascal's Triangle recursively up to the nth row
    public static void printTriangle(int n, int current) {
        // Base case: if current row index exceeds n, stop recursion
        if (current > n) {
            return;
        }

        // Recursive call to print the next row first (to print in correct order)
        printTriangle(n, current + 1);
        // Print the current row
        printRow(generateRow(current), n, current);
    }

    // Helper function to print a single row of Pascal's Triangle
    public static void printRow(int[] row, int maxRows, int currentRow) {
        // Calculate the number of spaces needed for proper alignment
        int spaces = maxRows - currentRow;
        // Print the spaces before the row elements
        printSpaces(spaces);
        // Print the row elements
        printArray(row, 0);
        // Move to the next line after printing the row
        System.out.println();
    }

    // Helper function to print a given number of spaces recursively
    public static void printSpaces(int count) {
        // Base case: if count is zero, stop recursion
        if (count == 0) {
            return;
        }
        // Print a single space
        System.out.print(" ");
        // Recursive call to print the next space
        printSpaces(count - 1);
    }

    // Helper function to print array elements recursively
    public static void printArray(int[] array, int index) {
        // Base case: if index reaches the end of the array, stop recursion
        if (index == array.length) {
            return;
        }
        // Print the current array element followed by a space
        System.out.print(array[index] + " ");
        // Recursive call to print the next element
        printArray(array, index + 1);
    }

    public static void main(String[] args) {
        int n = 10; // Number of rows for Pascal's Triangle
        // Start printing Pascal's Triangle from row 0 to row (n-1)
        printTriangle(n - 1, 0);
    }
}


