package graph;

import java.util.*;

public class TopoSort {

  public List<Integer> topoSort_Bfs(List<List<Integer>> adjList) {
    int n = adjList.size();
    int[] inDegree = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < adjList.get(i).size(); j++) {
        inDegree[adjList.get(i).get(j)]++;
      }
    }
    Queue<Integer> q = new ArrayDeque<>();
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }
    if (q.size() == 0) {
      System.out.println("All in degrees != 0 -> Contain cycle!");
    }
    while (!q.isEmpty()) {
      int current = q.poll();
      res.add(current);
      for (int i = 0; i < adjList.get(current).size(); i++) {
        int neighbor = adjList.get(current).get(i);
        inDegree[neighbor]--;
        if (inDegree[neighbor] == 0) {
          q.add(neighbor);
        }
      }
    }
    return res;
  }

  public List<Integer> topoSort_Dfs(List<List<Integer>> adjList) {
    int n = adjList.size();
    boolean[] visited = new boolean[n];
    Stack<Integer> stk = new Stack<>();

    for (int i = 0; i < adjList.size(); i++) {
      if (!visited[i]) {
        dfs(adjList, i, visited, stk);
      }
    }

    return stk.reversed();
  }

  private void dfs(List<List<Integer>> adjList, int current, boolean[] visited, Stack<Integer> stk) {
    visited[current] = true;
    for (int i = 0; i < adjList.get(current).size(); i++) {
      int neighbor = adjList.get(current).get(i);
      if (!visited[neighbor]) {
        dfs(adjList, neighbor, visited, stk);
      }
    }
    stk.add(current);
  }

  public static void main(String[] args) {
    TopoSort t = new TopoSort();
    List<List<Integer>> adjList = List.of(
        List.of(1, 2),
        List.of(2, 3),
        List.of(4),
        List.of(5, 6),
        List.of(5),
        List.of(),
        List.of()
    );
    System.out.println(t.topoSort_Bfs(adjList));
    System.out.println(t.topoSort_Dfs(adjList));
  }
}
