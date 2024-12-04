import java.util.Scanner;

public class MenuDrivenProgram {

    // Linear Search Algorithm
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;  // Return index if key is found
            }
        }
        return -1;  // Return -1 if key is not found
    }

    // Method to display Sparse Matrix
    public static void displaySparseMatrix(int[][] matrix) {
        System.out.println("Sparse Matrix representation (only non-zero elements):");
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Displaying non-zero elements in a sparse matrix format
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    System.out.println("Row: " + i + " Column: " + j + " Value: " + matrix[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Linear Search");
            System.out.println("2. Display Sparse Matrix");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Linear Search
                    System.out.print("Enter the number of elements in the array: ");
                    int n = scanner.nextInt();
                    int[] arr = new int[n];

                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < n; i++) {
                        arr[i] = scanner.nextInt();
                    }

                    System.out.print("Enter the element to search for: ");
                    int key = scanner.nextInt();

                    int index = linearSearch(arr, key);

                    if (index != -1) {
                        System.out.println("Element found at index: " + index);
                    } else {
                        System.out.println("Element not found in the array.");
                    }
                    break;

                case 2:
                    // Display Sparse Matrix
                    System.out.print("Enter number of rows in the matrix: ");
                    int rows = scanner.nextInt();
                    System.out.print("Enter number of columns in the matrix: ");
                    int cols = scanner.nextInt();

                    int[][] matrix = new int[rows][cols];

                    System.out.println("Enter the elements of the matrix:");
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            matrix[i][j] = scanner.nextInt();
                        }
                    }

                    // Call function to display sparse matrix
                    displaySparseMatrix(matrix);
                    break;

                case 3:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
