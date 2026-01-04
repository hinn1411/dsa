package linked_list;

import org.w3c.dom.ls.LSException;

public class ReorderList {
   static public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    public void print() {
      ListNode  walker = this;
      while (walker != null) {
        System.out.print(walker.val + " ");
        walker = walker.next;
      }
      System.out.println();
    }
  }

  public void reorderList(ListNode head) {
    ListNode mid = getMid(head);
    ListNode reversedSecond = reverseList(mid.next);
    mid.next = null;

    ListNode l1 = head, l2 = reversedSecond;
    while (l2 != null) {
      ListNode l1Next = l1.next, l2Next = l2.next;
      l1.next = l2;
      l2.next = l1Next;
      l1 = l1Next;
      l2 = l2Next;
    }
  }

  private ListNode getMid(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode slow  = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverseList(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode prev = null, cur = head, next;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
  public static void main(String[] args) {
    ReorderList r = new ReorderList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    r.reorderList(head);
    head.print();

  }
}
