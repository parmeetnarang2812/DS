/*
import java.io.*;
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

    public static boolean isCyclic(ArrayList<Edge>[] graph, boolean[] visited, int src) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(src);

        while (que.size() != 0) {
            int rvtx = que.remove();
            if (visited[rvtx] == true) {
                return true;
            }
            visited[rvtx] = true;
            for (Edge e : graph[rvtx]) {
                if (!visited[e.nbr]) {
                    que.add(e.nbr);
                }
            }
        }
        return false;
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
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                boolean isCyclic = isCyclic(graph, visited, i);
                if (isCyclic == true) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
}
*/