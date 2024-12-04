import java.util.*;

public class Graph {
    
    private int[][] adjMatrix;  // Adjacency Matrix representation of the graph
    private int numNodes;       // Number of nodes in the graph
    
    // Constructor to initialize the graph with N nodes
    public Graph(int n) {
        numNodes = n;
        adjMatrix = new int[n][n];
    }
    
    // Method to add an edge from node u to node v
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;  // Directed edge from u to v
    }
    
    // Method to perform BFS and print all reachable nodes from a given start node
    public void BFS(int startNode) {
        boolean[] visited = new boolean[numNodes];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[startNode] = true;
        queue.add(startNode);
        
        System.out.println("BFS starting from node " + startNode + ":");
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            
            // Traverse all the adjacent nodes of the current node
            for (int i = 0; i < numNodes; i++) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }
    
    // Method to perform DFS and print all reachable nodes from a given start node
    public void DFS(int startNode) {
        boolean[] visited = new boolean[numNodes];
        System.out.println("DFS starting from node " + startNode + ":");
        DFSUtil(startNode, visited);
        System.out.println();
    }
    
    // Helper method for DFS (recursive)
    private void DFSUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        
        // Traverse all the adjacent nodes of the current node
        for (int i = 0; i < numNodes; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }
    
    // Method to print the adjacency matrix of the graph
    public void printGraph() {
        System.out.println("Adjacency Matrix of the Graph:");
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Menu-driven program
        System.out.print("Enter the number of nodes in the graph: ");
        int nodes = scanner.nextInt();
        
        Graph graph = new Graph(nodes);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Graph using Adjacency Matrix");
            System.out.println("2. BFS - Print all reachable nodes from a starting node");
            System.out.println("3. DFS - Print all reachable nodes from a starting node");
            System.out.println("4. Print Adjacency Matrix");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Create Graph
                    System.out.println("Creating a Graph with Adjacency Matrix.");
                    System.out.print("Enter the number of edges: ");
                    int edges = scanner.nextInt();
                    System.out.println("Enter the edges (u v) where u is the source node and v is the destination node:");
                    for (int i = 0; i < edges; i++) {
                        int u = scanner.nextInt();
                        int v = scanner.nextInt();
                        graph.addEdge(u, v);
                    }
                    break;
                    
                case 2:
                    // BFS - Print reachable nodes from a given start node
                    System.out.print("Enter the starting node for BFS: ");
                    int startBFS = scanner.nextInt();
                    graph.BFS(startBFS);
                    break;
                    
                case 3:
                    // DFS - Print reachable nodes from a given start node
                    System.out.print("Enter the starting node for DFS: ");
                    int startDFS = scanner.nextInt();
                    graph.DFS(startDFS);
                    break;
                    
                case 4:
                    // Print Adjacency Matrix
                    graph.printGraph();
                    break;
                    
                case 5:
                    // Exit
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
