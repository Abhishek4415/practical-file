import java.util.Scanner;

public class CircularQueue {
    private char[] queue;
    private int front, rear, size;

    // Constructor to initialize the circular queue
    public CircularQueue(int size) {
        this.size = size;
        this.queue = new char[size];
        this.front = -1;
        this.rear = -1;
    }

    // Method to insert an element onto the queue
    public void enqueue(char element) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue Overflow! Cannot insert " + element);
            return;
        }
        if (front == -1) {
            front = 0; // First element being inserted
        }
        rear = (rear + 1) % size;
        queue[rear] = element;
        System.out.println("Inserted: " + element);
    }

    // Method to delete an element from the queue
    public char dequeue() {
        if (front == -1) {
            System.out.println("Queue Underflow! No elements to delete.");
            return '\0'; // Return null character
        }
        char deletedElement = queue[front];
        if (front == rear) {
            front = rear = -1; // Queue becomes empty
        } else {
            front = (front + 1) % size;
        }
        System.out.println("Deleted: " + deletedElement);
        return deletedElement;
    }

    // Method to display the queue
    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Circular Queue: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the Circular Queue: ");
        int queueSize = scanner.nextInt();

        CircularQueue circularQueue = new CircularQueue(queueSize);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert an Element onto Circular Queue");
            System.out.println("2. Delete an Element from Circular Queue");
            System.out.println("3. Display Circular Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the character to insert: ");
                    char element = scanner.next().charAt(0);
                    circularQueue.enqueue(element);
                    break;

                case 2:
                    circularQueue.dequeue();
                    break;

                case 3:
                    circularQueue.display();
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
