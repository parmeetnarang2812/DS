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

    static class Pair {
        int vtx;
        int level;

        Pair(int vtx, int level) {
            this.vtx = vtx;
            this.level = level;
        }
    }

    public static boolean bipartite(ArrayList<Edge>[] graph, Integer[] visited, int src) {
        ArrayDeque<Pair> que = new ArrayDeque<Pair>();
        que.add(new Pair(src, 1));

        while (que.size() != 0) {
            Pair rp = que.remove();

            // if (visited[rp.vtx] != null) {
            //     if (visited[rp.vtx] != rp.level % 2) {
            //         return false;
            //     }
            // }

            if (visited[rp.vtx] != null) {
                int originalValue = visited[rp.vtx];
                int newValue = rp.level % 2;

                if (originalValue != newValue) {
                    return false;
                }
            }
            visited[rp.vtx] = rp.level % 2; // 0 for even, 1 for odd
            for (Edge e : graph[rp.vtx]) {
                if (visited[e.nbr] == null) {
                    que.add(new Pair(e.nbr, rp.level + 1));
                }
            }
        }
        return true;
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
        Integer[] visited = new Integer[vtces];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == null) {
                boolean isBipartite = bipartite(graph, visited, i);
                if (isBipartite == false) {
                    System.out.print(false);
                    return;
                }
            }
        }
        System.out.print(true);
    }
}
 */

    // leetcode accepted
/* class Solution {
    public boolean isBipartite(int[][] graph, int src, int[] vis) {
        // -1 -> undefine, 0 -> red, 1 -> green.

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        int color = 0;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();
                if (vis[rvtx] != -1) {
                    if (vis[rvtx] != color) // conflict
                        return false;

                    continue;
                }

                vis[rvtx] = color;
                for (int v : graph[rvtx]) {
                    if (vis[v] == -1) {
                        que.addLast(v);
                    }
                }
            }

            color = (color + 1) % 2;
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] vis = new int[N];
        Arrays.fill(vis, -1);

        for (int i = 0; i < N; i++) {
            if (vis[i] == -1) {
                if (!isBipartite(graph, i, vis)) {
                    return false;
                }
            }
        }

        return true;
    }
}  */