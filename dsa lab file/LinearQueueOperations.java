import java.util.Scanner;

class Queue {
    private char[] queue; // Array to store the queue elements
    private int front, rear, maxSize;

    // Constructor to initialize the queue
    public Queue(int size) {
        maxSize = size;
        queue = new char[maxSize];
        front = -1;
        rear = -1;
    }

    // Method to insert an element into the queue
    public void insert(char element) {
        if (rear == maxSize - 1) { // Check for overflow
            System.out.println("Queue Overflow! Cannot insert " + element);
        } else {
            if (front == -1) front = 0; // Update front if queue was empty
            queue[++rear] = element;
            System.out.println("Inserted " + element + " into the queue.");
        }
    }

    // Method to delete an element from the queue
    public void delete() {
        if (front == -1 || front > rear) { // Check for underflow
            System.out.println("Queue Underflow! Cannot delete from an empty queue.");
        } else {
            System.out.println("Deleted " + queue[front++] + " from the queue.");
            if (front > rear) { // Reset the queue if it becomes empty
                front = -1;
                rear = -1;
            }
        }
    }

    // Method to display the current status of the queue
    public void display() {
        if (front == -1 || front > rear) {
            System.out.println("The queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

public class LinearQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum size of the queue: ");
        int size = scanner.nextInt();
        Queue queue = new Queue(size);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert an Element into the Queue");
            System.out.println("2. Delete an Element from the Queue");
            System.out.println("3. Display the Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a character to insert: ");
                    char element = scanner.next().charAt(0);
                    queue.insert(element);
                    break;
                case 2:
                    queue.delete();
                    break;
                case 3:
                    queue.display();
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
