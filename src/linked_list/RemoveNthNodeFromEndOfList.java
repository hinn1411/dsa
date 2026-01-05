package linked_list;

public class RemoveNthNodeFromEndOfList {

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

  public int getListSize(ListNode head) {
    if (head == null) {
      return 0;
    }

    int count = 0;
    ListNode walker = head;
    while (walker != null) {
      walker = walker.next;
      count++;
    }
    return count;

  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    int listSize = getListSize(head);
    if (listSize == 1) {
      return null;
    }
    if (n == listSize) {
      return head.next;
    }

    ListNode walker = head;
    for (int i = 1; i < listSize - n; i++) {
      walker = walker.next;
    }

    ListNode next = walker.next;
    walker.next = next.next;
    next.next = null;

    return head;
  }

  public ListNode removeNthFromEnd_Optimize(ListNode head, int n) {
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;
    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
    head = r.removeNthFromEnd_Optimize(head, 2);
    head.print();

  }
}
