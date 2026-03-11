package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

  public int countComponents(int n, int[][] edges) {
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int[] edge: edges) {
      int u = edge[0], v = edge[1];
      adjList.get(u).add(v);
      adjList.get(v).add(u);
    }
    boolean[] visited = new boolean[n];
    int components = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(adjList, i, visited);
        components++;
      }
    }

    return components;
  }

  private void dfs(List<List<Integer>> adjList, int current, boolean[] visited) {
    visited[current] = true;
    for (int neighbor: adjList.get(current)) {
      if (!visited[neighbor]) {
        dfs(adjList, neighbor, visited);
      }
    }
  }

  public static void main(String[] args) {
    NumberOfConnectedComponentsInAnUndirectedGraph n = new NumberOfConnectedComponentsInAnUndirectedGraph();
    int[][] e1 = new int[][]{{0,1},{1,2},{3,4}};
    int[][] e2 = new int[][]{{0,1},{1,2},{2,3},{3,4}};
    int[][] e3 = {{0,1},{0,2},{2,3},{2,4}};
    System.out.println(n.countComponents(5, e1));
    System.out.println(n.countComponents(5, e2));
    System.out.println(n.countComponents(5, e3));


  }
}
