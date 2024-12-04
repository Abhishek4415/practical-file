import java.util.Scanner;

class SinglyLinkedList {
    // Node class to represent each element in the list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Constructor to initialize the list as empty
    public SinglyLinkedList() {
        head = null;
    }

    // a. Create a SLL
    public void createSLL() {
        head = null; // Clear the list
        System.out.println("Singly Linked List is created.");
    }

    // b. Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + data + " at the beginning.");
    }

    // c. Insert at the last
    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Inserted " + data + " at the last.");
    }

    // d. Insert at any random location
    public void insertAtRandomLocation(int data, int position) {
        if (position <= 0) {
            System.out.println("Position must be greater than 0.");
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position is out of range.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Inserted " + data + " at position " + position + ".");
        }
    }

    // e. Delete from the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
        } else {
            System.out.println("Deleted " + head.data + " from the beginning.");
            head = head.next;
        }
    }

    // f. Delete from the last
    public void deleteFromLast() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
        } else if (head.next == null) {
            System.out.println("Deleted " + head.data + " from the last.");
            head = null;
        } else {
            Node current = head;
            while (current.next != null && current.next.next != null) {
                current = current.next;
            }
            System.out.println("Deleted " + current.next.data + " from the last.");
            current.next = null;
        }
    }

    // g. Delete node after specified location
    public void deleteAfterLocation(int position) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == null) {
            System.out.println("No node to delete after position " + position);
        } else {
            System.out.println("Deleted " + current.next.data + " after position " + position);
            current.next = current.next.next;
        }
    }

    // h. Search for an element
    public void searchElement(int data) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == data) {
                System.out.println("Element " + data + " found at position " + position);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("Element " + data + " not found in the list.");
    }

    // i. Show the linked list
    public void show() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            Node current = head;
            System.out.print("List: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class SinglyLinkedListMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create a Singly Linked List");
            System.out.println("2. Insert at Beginning");
            System.out.println("3. Insert at Last");
            System.out.println("4. Insert at Random Location");
            System.out.println("5. Delete from Beginning");
            System.out.println("6. Delete from Last");
            System.out.println("7. Delete Node after Specified Location");
            System.out.println("8. Search for an Element");
            System.out.println("9. Show the List");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    list.createSLL();
                    break;
                case 2:
                    System.out.print("Enter value to insert at beginning: ");
                    int dataAtBeginning = scanner.nextInt();
                    list.insertAtBeginning(dataAtBeginning);
                    break;
                case 3:
                    System.out.print("Enter value to insert at last: ");
                    int dataAtLast = scanner.nextInt();
                    list.insertAtLast(dataAtLast);
                    break;
                case 4:
                    System.out.print("Enter value to insert at a random location: ");
                    int dataAtRandom = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int positionAtRandom = scanner.nextInt();
                    list.insertAtRandomLocation(dataAtRandom, positionAtRandom);
                    break;
                case 5:
                    list.deleteFromBeginning();
                    break;
                case 6:
                    list.deleteFromLast();
                    break;
                case 7:
                    System.out.print("Enter position after which to delete node: ");
                    int positionToDelete = scanner.nextInt();
                    list.deleteAfterLocation(positionToDelete);
                    break;
                case 8:
                    System.out.print("Enter element to search: ");
                    int searchElement = scanner.nextInt();
                    list.searchElement(searchElement);
                    break;
                case 9:
                    list.show();
                    break;
                case 10:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
