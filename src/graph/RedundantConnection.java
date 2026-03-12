package graph;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
  public int[] findRedundantConnection(int[][] edges) {
    List<List<Integer>> adjList = new ArrayList<>();
    int n = edges.length + 1;
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    boolean[] visited;
    for (int[] edge : edges) {
      int u = edge[0], v = edge[1];
      visited = new boolean[n];
      if (dfs(adjList, u, v, visited)) {
        return edge;
      }
      adjList.get(u).add(v);
      adjList.get(v).add(u);
    }
    return new int[]{-1, -1};
  }

  private boolean dfs(List<List<Integer>> adjList, int src, int des, boolean[] visited) {
    visited[src] = true;
    for (int neighbor : adjList.get(src)) {
      if (neighbor == des) {
        return true;
      }
      if (!visited[neighbor]) {
        if (dfs(adjList, neighbor, des, visited)) {
          return true;
        }
      }

    }
    return false;
  }

  public static void main(String[] args) {

  }
}
