import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null; // Array is initially null
        int size = 0; // To store the size of the array

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create an Array of N Integer Elements");
            System.out.println("2. Display Array Elements");
            System.out.println("3. Insert an Element at a Given Position");
            System.out.println("4. Delete an Element at a Given Position");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Create array
                    System.out.print("Enter the number of elements (N): ");
                    size = scanner.nextInt();
                    array = new int[size];
                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        array[i] = scanner.nextInt();
                    }
                    System.out.println("Array created successfully.");
                    break;

                case 2: // Display array
                    if (array == null) {
                        System.out.println("Array not created yet.");
                    } else {
                        System.out.println("Array elements are:");
                        for (int num : array) {
                            System.out.print(num + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3: // Insert an element
                    if (array == null) {
                        System.out.println("Array not created yet.");
                    } else {
                        System.out.print("Enter the position to insert (1 to " + (size + 1) + "): ");
                        int pos = scanner.nextInt();
                        if (pos < 1 || pos > size + 1) {
                            System.out.println("Invalid position!");
                        } else {
                            System.out.print("Enter the element to insert: ");
                            int element = scanner.nextInt();
                            int[] newArray = new int[size + 1];
                            for (int i = 0, j = 0; i < size + 1; i++) {
                                if (i == pos - 1) {
                                    newArray[i] = element;
                                } else {
                                    newArray[i] = array[j++];
                                }
                            }
                            array = newArray;
                            size++;
                            System.out.println("Element inserted successfully.");
                        }
                    }
                    break;

                case 4: // Delete an element
                    if (array == null) {
                        System.out.println("Array not created yet.");
                    } else {
                        System.out.print("Enter the position to delete (1 to " + size + "): ");
                        int pos = scanner.nextInt();
                        if (pos < 1 || pos > size) {
                            System.out.println("Invalid position!");
                        } else {
                            int[] newArray = new int[size - 1];
                            for (int i = 0, j = 0; i < size; i++) {
                                if (i == pos - 1) continue;
                                newArray[j++] = array[i];
                            }
                            array = newArray;
                            size--;
                            System.out.println("Element deleted successfully.");
                        }
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
