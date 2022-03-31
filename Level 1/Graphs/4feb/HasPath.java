/*
import java.io.*;
import java.util.*;

public class HasPath {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt){
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static boolean hasPath(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest) {
      //check if src==dest i.e. src is 6 & dest is 6, then, a path is there -> not to move
      if(src==dest) {
         return true;
      }

      visited[src] = true;
      for(int i=0; i<graph[src].size(); i++) {  //loop for all edges of a vtx
         Edge edge = graph[src].get(i); //gets each edge
         int nbr = edge.nbr; //neighbour vtces

         if(visited[nbr] == false) {
            boolean pathFromNbrExists = hasPath(graph, visited, nbr, dest);
            if(pathFromNbrExists) {
               return true;
            }
         }
      }

      return false; //no path
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[vtces];
      for(int i = 0; i < vtces; i++){
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for(int i = 0; i < edges; i++){
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      boolean[] visited = new boolean[vtces];
      System.out.println(hasPath(graph, visited, src, dest));

    }

}
*/