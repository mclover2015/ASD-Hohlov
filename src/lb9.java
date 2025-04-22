import java.util.*;

public class lb9 {

    static final int INF = 9999;
    static final int V = 6;

    static String[] vertices = {"a", "b", "c", "d", "e", "f"};

    static int[][] adjacencyMatrix = {
            // a  b  c  d  e  f
            { 0, 1, 1, 1, 1, 0 }, // a
            { 1, 0, 0, 1, 0, 1 }, // b
            { 1, 0, 0, 1, 1, 0 }, // c
            { 1, 1, 1, 0, 0, 1 }, // d
            { 1, 0, 1, 0, 0, 1 }, // e
            { 0, 1, 0, 1, 1, 0 }  // f
    };


    static void dijkstra(int start) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && adjacencyMatrix[u][v] != 0 &&
                        dist[u] + adjacencyMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + adjacencyMatrix[u][v];
                }
            }
        }

        System.out.println("deikkkr (from " + vertices[start] + "):");
        for (int i = 0; i < V; i++) {
            System.out.println(vertices[start] + " -> " + vertices[i] + " = " + dist[i]);
        }
    }

    static int minDistance(int[] dist, boolean[] visited) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }


    static void floydWarshall() {
        int[][] dist = new int[V][V];


        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else if (adjacencyMatrix[i][j] != 0)
                    dist[i][j] = adjacencyMatrix[i][j];
                else
                    dist[i][j] = INF;
            }
        }


        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println("\nFloyd-Warshall :");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print((dist[i][j] == INF ? "INF" : dist[i][j]) + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        dijkstra(0); // from vertex 'a'
        floydWarshall();
    }
}
