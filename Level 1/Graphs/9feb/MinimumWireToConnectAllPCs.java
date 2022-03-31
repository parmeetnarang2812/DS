/* import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // write your code here
        boolean[] visited = new boolean[vtces];
        minimumWire(graph, visited);
    }

    static class Pair implements Comparable<Pair> {
        int vtx;
        int path;
        int cost;

        Pair(int vtx, int path, int cost) {
            this.vtx = vtx;
            this.path = path;
            this.cost = cost;
        }

        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    public static void minimumWire(ArrayList<Edge>[] graph, boolean[] visited) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));

        while (pq.size() != 0) {
            Pair rem = pq.remove(); // remove

            if (visited[rem.vtx]) {
                continue;
            }

            visited[rem.vtx] = true; // mark

            if (rem.path != -1) { // work
                System.out.println("[" + rem.vtx + "-" + rem.path + "@" + rem.cost + "]");
            }

            for (Edge e : graph[rem.vtx]) {
                if (!visited[e.nbr]) {
                    pq.add(new Pair(e.nbr, rem.vtx, e.wt));
                }
            }
        }
    }

} */