package graph;

import java.util.*;

public class DFS {
  private static List<List<Integer>> graph;
  private static int V;
  private static int E;
  private static int[] path;
  private static boolean[] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    V = sc.nextInt();
    E = sc.nextInt();
    graph = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < E; i++) {
       int u = sc.nextInt(), v = sc.nextInt();
       graph.get(u).add(v);
       graph.get(v).add(u);
    }

    int s = 0, f = 5;
    dfs_Stack(s);
    printPath(s, f);
    visited = new boolean[V];
    path = new int[V];
    Arrays.fill(path, -1);
    dfs_Recursion(s);
    printPath(s, f);
  }

  private static void dfs_Stack(int source) {
    visited = new boolean[V];
    path = new int[V];
    Arrays.fill(path, -1);

    Stack<Integer> stk = new Stack<>();
    stk.add(source);
    visited[source] = true;
    while (!stk.isEmpty()) {
      Integer current = stk.pop();
      for (int i = 0; i < graph.get(current).size(); i++) {
        int neighbor = graph.get(current).get(i);
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          stk.add(neighbor);
          path[neighbor] = current;
        }
      }
    }
  }

  private static void dfs_Recursion(int current) {
    visited[current] = true;
    for (int i = 0; i < graph.get(current).size(); i++) {
      int neighbor = graph.get(current).get(i);
      if (!visited[neighbor]) {
        path[neighbor] = current;
        dfs_Recursion(neighbor);
      }
    }
  }

  private static void printPath(int source, int destination) {
    if (path[destination] == -1) {
      System.out.println("Cannot reach destination from any source!");
      return;
    }

    int current = destination;
    List<Integer> b = new ArrayList<>();
    while (true) {
      b.add(current);
      current = path[current];
      if (current == source) {
        b.add(current);
        break;
      }
    }

    System.out.println(b.reversed());
  }
}
