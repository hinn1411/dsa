package graph;

import java.util.*;

public class BFS {
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
      int u = sc.nextInt();
      int v = sc.nextInt();
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    int s = 0, f = 5;
    bfs(s);
    printPath(s, f);

  }

  private static void bfs(int source) {
    visited = new boolean[V];
    path = new int[V];
    Arrays.fill(path, -1);

    Queue<Integer> q = new ArrayDeque<>();
    q.add(source);
    visited[source] = true;
    while (!q.isEmpty()) {
      Integer cur = q.poll();
      for (int i = 0; i < graph.get(cur).size(); i++) {
        int next = graph.get(cur).get(i);
        if (!visited[next]) {
          q.add(next);
          visited[next] = true;
          path[next] = cur;
        }
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

