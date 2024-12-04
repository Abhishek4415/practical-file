import java.util.Scanner;

public class BinarySearchTree {

    // Define the Node structure
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Root of the BST
    Node root;

    // Method to insert a new node in the BST
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Method to perform Inorder Traversal
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Method to perform Preorder Traversal
    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Method to perform Postorder Traversal
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Main method to handle menu-driven program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BinarySearchTree bst = new BinarySearchTree();

        // Predefined values to create the BST
        int[] values = {8, 10, 3, 1, 6, 14, 7};

        // Insert values into the BST
        for (int value : values) {
            bst.root = bst.insert(bst.root, value);
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create BST of N Integers");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Preorder Traversal");
            System.out.println("4. Postorder Traversal");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create the BST
                    bst.root = null;  // Clear the tree if it exists
                    System.out.println("Creating BST with predefined values: 8, 10, 3, 1, 6, 14, 7");
                    for (int value : values) {
                        bst.root = bst.insert(bst.root, value);
                    }
                    System.out.println("BST created successfully.");
                    break;

                case 2:
                    // Inorder Traversal
                    System.out.println("Inorder Traversal:");
                    bst.inorder(bst.root);
                    System.out.println();
                    break;

                case 3:
                    // Preorder Traversal
                    System.out.println("Preorder Traversal:");
                    bst.preorder(bst.root);
                    System.out.println();
                    break;

                case 4:
                    // Postorder Traversal
                    System.out.println("Postorder Traversal:");
                    bst.postorder(bst.root);
                    System.out.println();
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
