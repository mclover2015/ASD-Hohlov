import java.util.*;

public class lb10 {

    static final int INF = 99999;


    static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];


        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];


        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        System.out.println("Floyd-Warshall shortest distances:");
        printMatrix(dist);
    }


    static void dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++)
                if (!visited[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        System.out.println("Dijkstra shortest distances from node " + src + ":");
        for (int i = 0; i < V; i++)
            System.out.println("To " + i + ": " + dist[i]);
    }

    static int minDistance(int[] dist, boolean[] visited) {
        int min = INF, min_index = -1;

        for (int v = 0; v < dist.length; v++)
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print((val == INF ? "INF" : val) + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {

                {0, 6, INF, 1, INF},
                {6, 0, 5, 2, 2},
                {INF, 5, 0, INF, 5},
                {1, 2, INF, 0, 1},
                {INF, 2, 5, 1, 0}
        };

        dijkstra(graph, 0);
        System.out.println();
        floydWarshall(graph);
    }
}
