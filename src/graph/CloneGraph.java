package graph;

import java.util.*;

public class CloneGraph {
  public static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Queue<Node> q = new ArrayDeque<>();
    Map<Node, Node> mapper = new HashMap<>();
    mapper.put(node, new Node(node.val));
    q.add(node);
    while (!q.isEmpty()) {
      Node current = q.poll();

      for (Node neighbor: current.neighbors) {
        if (!mapper.containsKey(neighbor)) {
          mapper.put(neighbor, new Node(neighbor.val));
          q.add(neighbor);
        }

        mapper.get(current).neighbors.add(mapper.get(neighbor));

      }
    }
    return mapper.get(node);
  }
  public static void main(String[] args) {

  }
}
