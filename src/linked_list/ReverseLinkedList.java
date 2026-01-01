package linked_list;

public class ReverseLinkedList {
  public static class ListNode {
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
      ListNode walker = this;
      while (walker != null) {
        System.out.print(walker.val + " ");
        walker = walker.next;
      }
      System.out.println();
    }
  }

  public ListNode reverseList(ListNode head) {
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
    ReverseLinkedList r = new ReverseLinkedList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head = r.reverseList(head);
    head.print();
  }
}
