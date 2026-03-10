package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {

  public boolean validTree(int n, int[][] edges) {
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
    if (dfs(adjList, 0, -1, visited)) {
      return false;
    }
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(List<List<Integer>> adjList, int current, int parent, boolean[] visited) {
    visited[current] = true;
    for (int neighbor: adjList.get(current)) {
      if (!visited[neighbor]) {
        if (dfs(adjList, neighbor, current, visited)) {
          return true;
        }
      } else if (neighbor != parent) {
        return true;
      }
    }
    return false;
  }


  public static void main(String[] args) {
    GraphValidTree g = new GraphValidTree();
    int[][] e1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    int[][] e2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
    System.out.println(g.validTree(5, e1));
    System.out.println(g.validTree(5, e2));
  }
}
