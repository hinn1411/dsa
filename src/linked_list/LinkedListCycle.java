package linked_list;

import java.util.HashSet;

public class LinkedListCycle {
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public boolean hasCycle(ListNode head) {
    ListNode walker = head;
    HashSet<ListNode> visitedNodes = new HashSet<>();

    while (walker != null) {
      if (!visitedNodes.contains(walker)) {
        visitedNodes.add(walker);
      } else {
        return true;
      }
      walker = walker.next;
    }
    return false;
  }

  public boolean fastAndSlow(ListNode head) {
    if (head == null) {
      return false;
    }

    ListNode fast = head, slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    LinkedListCycle l = new LinkedListCycle();
    ListNode head =  new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = head;
    System.out.println(l.fastAndSlow(head));
  }

}
