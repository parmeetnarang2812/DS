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

        // write all your codes here
        boolean[] visited = new boolean[vtces];
        travelAround(graph, visited, src, src + "", 1, src);
    }

    public static void travelAround(ArrayList<Edge>[] graph, boolean[] visited, int src, String psf, int csf, int orig) {
        if (csf == graph.length) {
            System.out.print(psf);
            boolean closingEdgeFound = false;
            for (Edge e : graph[src]) {
                if (e.nbr == orig) {
                    closingEdgeFound = true;
                    break;
                }
            }
            if (closingEdgeFound) {
                System.out.println("*");    //cycle
            } else {
                System.out.println(".");    //path
            }
            return;
        }

        visited[src] = true;

        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                travelAround(graph, visited, e.nbr, psf + e.nbr, csf + 1, orig);
            }
        }

        visited[src] = false;
    }

}
 */