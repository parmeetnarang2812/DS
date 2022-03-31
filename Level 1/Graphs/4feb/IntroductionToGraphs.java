/*
import java.util.*;

public class IntroductionToGraphs {
  static class Edge {
    int v1;
    int v2;
    int wt;

    Edge(int v1, int v2, int wt) {
      this.v1 = v1;
      this.v2 = v2;
      this.wt = wt;
    }
  }
  public static void main(String[] args) throws Exception {
    ArrayList<Edge>[] graph = new ArrayList[7]; //0 1 2 3 4 5 6
    for(int i=0; i<graph.length; i++) {
        graph[i] = new ArrayList<>();
    }
    
    graph[0].add(new Edge(0, 1, 10));
    graph[0].add(new Edge(0, 3, 40));

    graph[1].add(new Edge(1, 0, 10));
    graph[1].add(new Edge(1, 2, 10));

    graph[2].add(new Edge(2, 1, 10));
    graph[2].add(new Edge(2, 3, 10));

    graph[3].add(new Edge(3, 3, 10));
    graph[3].add(new Edge(3, 0, 40));
    graph[3].add(new Edge(3, 4, 2));

    graph[4].add(new Edge(4, 3, 2));
    graph[4].add(new Edge(4, 5, 3));
    graph[4].add(new Edge(4, 6, 8));

    graph[5].add(new Edge(5, 4, 3));
    graph[5].add(new Edge(5, 6, 3));

    graph[6].add(new Edge(5, 5, 3));
    graph[6].add(new Edge(5, 4, 8));    

  }
}
*/