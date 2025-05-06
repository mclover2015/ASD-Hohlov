import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Graph {
    int V;
    ArrayList<Edge> edges;
    int comparisonCountKruskal = 0;
    int comparisonCountPrim = 0;

    Graph(int v) {
        V = v;
        edges = new ArrayList<>();
    }

    void addEdge(int s, int d, int w) {
        edges.add(new Edge(s, d, w));
    }

    // Find MST using Kruskal
    void kruskalMST() {
        Collections.sort(edges);
        int[] parent = new int[V];
        for (int i = 0; i < V; ++i)
            parent[i] = i;

        ArrayList<Edge> result = new ArrayList<>();
        for (Edge e : edges) {
            int x = find(parent, e.src);
            int y = find(parent, e.dest);
            comparisonCountKruskal++;
            if (x != y) {
                result.add(e);
                union(parent, x, y);
            }
        }

        System.out.println("\nKruskal's MST:");
        printMST(result);
        System.out.println("Total comparisons (Kruskal): " + comparisonCountKruskal);
    }

    int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }


    void primMST() {
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (Edge e : edges) {
                int v = (e.src == u) ? e.dest : (e.dest == u ? e.src : -1);
                if (v != -1 && !mstSet[v] && e.weight < key[v]) {
                    key[v] = e.weight;
                    parent[v] = u;
                    comparisonCountPrim++;
                }
            }
        }

        ArrayList<Edge> result = new ArrayList<>();
        for (int i = 1; i < V; i++) {
            int u = parent[i];
            int w = findEdgeWeight(u, i);
            result.add(new Edge(u, i, w));
        }

        System.out.println("Prim's MST:");
        printMST(result);
        System.out.println("Total comparisons (Prim): " + comparisonCountPrim);
    }

    int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            comparisonCountPrim++;
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    int findEdgeWeight(int u, int v) {
        for (Edge e : edges)
            if ((e.src == u && e.dest == v) || (e.src == v && e.dest == u))
                return e.weight;
        return 0;
    }

    void printMST(List<Edge> mst) {
        int total = 0;
        for (Edge e : mst) {
            System.out.println(e.src + " - " + e.dest + " = " + e.weight);
            total += e.weight;
        }
        System.out.println("Total weight: " + total);
    }
}

public class lb11 {
    public static void main(String[] args) {
        Graph g = new Graph(9);

        // add rebra
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 4);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 3, 6);
        g.addEdge(2, 5, 1);
        g.addEdge(3, 4, 2);
        g.addEdge(3, 6, 4);
        g.addEdge(4, 5, 5);
        g.addEdge(4, 7, 7);
        g.addEdge(5, 8, 4);
        g.addEdge(6, 7, 3);
        g.addEdge(7, 8, 2);
        g.addEdge(6, 8, 1);
        g.addEdge(0, 5, 1);
        g.addEdge(2, 4, 6);
        g.addEdge(1, 3, 5);
        g.addEdge(0, 2, 3);

        g.primMST();
        g.kruskalMST();
    }
}
