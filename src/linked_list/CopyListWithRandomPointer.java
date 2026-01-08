package linked_list;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    Map<Node, Node> m = new HashMap<>();
    Node cur = head;
    while (cur != null) {
      m.put(cur, new Node(cur.val));
      cur = cur.next;
    }

    cur = head;
    while (cur != null) {
      m.get(cur).next = m.get(cur.next);
      m.get(cur).random = m.get(cur.random);
      cur = cur.next;
    }

    return m.get(head);
  }

  public static void main(String[] args) {

  }
}
