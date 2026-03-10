package graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class DetectCycle {

  public boolean detect_Dfs(List<List<Integer>> adjList) {
    int n = adjList.size();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i] && dfs(adjList, i, -1, visited)) {
        return true;
      }
    }
    return false;
  }

  private boolean dfs(List<List<Integer>> adjList, int current, int parent, boolean[] visited) {
    visited[current] = true;
    for (int i = 0; i < adjList.get(current).size(); i++) {
      int neighbor = adjList.get(current).get(i);
      if (!visited[neighbor]) {
        if (dfs(adjList, neighbor, current, visited)) {
          return true;
        }
      }
      if (neighbor != parent) {
        return true;
      }
    }
    return false;
  }

  public boolean detect_Bfs(List<List<Integer>> adjList) {
    int n = adjList.size();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i] && bfs(adjList, i, visited)) {
        return true;
      }
    }
    return false;
  }

  private boolean bfs(List<List<Integer>> adjList, int start , boolean[] visited) {
    Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{start, -1});
    visited[start] = true;

    while (!q.isEmpty()) {
      int[] head = q.poll();
      int current = head[0], parent = head[1];
      for (int neighbor: adjList.get(start)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          q.add(new int[] {neighbor, current});
        }
        if (neighbor != parent) {
          return true;
        }
      }
    }
    return false;
  }
  public static void main(String[] args) {
    List<List<Integer>> l = List.of(
        List.of(1),
        List.of(2,3,4),
        List.of(3),
        List.of(),
        List.of()
    );
    DetectCycle d = new DetectCycle();
    System.out.println(d.detect_Bfs(l));
    System.out.println(d.detect_Dfs(l));
  }
}
