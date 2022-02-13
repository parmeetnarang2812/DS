//  Dijikstra's Algorihtm -> shortest path in terms of weight
//  BFS -> shortest path in terms of vertices/edges     

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

    static class Triplet implements Comparable<Triplet> {
        int vtx;
        String psf;
        int wsf;

        Triplet(int vtx, String psf, int wsf) {
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Triplet o) {
            return this.wsf - o.wsf;
        }
    }

    public static void shortestPath(ArrayList<Edge>[] graph, int src) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<Triplet> pq = new PriorityQueue<Triplet>();
        pq.add(new Triplet(src, src + "", 0));

        while (pq.size() != 0) {
            Triplet rp = pq.remove();
            if (visited[rp.vtx] == true) {
                continue;
            }
            visited[rp.vtx] = true;
            System.out.println(rp.vtx + " via " + rp.psf + " @ " + rp.wsf);
            for (Edge e : graph[rp.vtx]) {
                if (!visited[e.nbr]) {
                    pq.add(new Triplet(e.nbr, rp.psf + e.nbr, rp.wsf + e.wt));
                }
            }
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

        int src = Integer.parseInt(br.readLine());
        // write your code here
        shortestPath(graph, src);

    }
} */