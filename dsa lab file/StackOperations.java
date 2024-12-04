import java.util.Scanner;

class Stack {
    private int[] stack; // Array to implement stack
    private int top;     // Top of the stack
    private int maxSize; // Maximum size of the stack

    // Constructor to initialize the stack
    public Stack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1; // Stack is initially empty
    }

    // Push an element onto the stack
    public void push(int element) {
        if (top >= maxSize - 1) {
            System.out.println("Stack Overflow! Cannot push " + element);
        } else {
            stack[++top] = element;
            System.out.println("Pushed " + element + " onto the stack.");
        }
    }

    // Pop an element from the stack
    public void pop() {
        if (top < 0) {
            System.out.println("Stack Underflow! Cannot pop from an empty stack.");
        } else {
            System.out.println("Popped " + stack[top--] + " from the stack.");
        }
    }

    // Check if a string is a palindrome using the stack
    public void checkPalindrome(String str) {
        Stack tempStack = new Stack(str.length());

        // Push characters into the stack
        for (char ch : str.toCharArray()) {
            tempStack.push(ch);
        }

        // Pop characters to build the reversed string
        StringBuilder reversed = new StringBuilder();
        while (tempStack.top >= 0) {
            reversed.append((char) tempStack.stack[tempStack.top--]);
        }

        // Compare the original string with the reversed string
        if (str.equals(reversed.toString())) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }

    // Display the current status of the stack
    public void display() {
        if (top < 0) {
            System.out.println("The stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

public class StackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum size of the stack: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Push an element onto the stack");
            System.out.println("2. Pop an element from the stack");
            System.out.println("3. Check if a string is a palindrome");
            System.out.println("4. Display the status of the stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.print("Enter a string to check for palindrome: ");
                    scanner.nextLine(); // Consume leftover newline
                    String str = scanner.nextLine();
                    stack.checkPalindrome(str);
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
