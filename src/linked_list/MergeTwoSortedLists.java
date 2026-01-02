package linked_list;

public class MergeTwoSortedLists {
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

  public ListNode mergeTwoLists(ListNode first, ListNode second) {
    ListNode newHead = new ListNode();
    ListNode walker = newHead;
    while (first != null && second != null) {
      int firstVal = first.val, secondVal = second.val;
      if (firstVal <= secondVal) {
        walker.next = first;
        first = first.next;
      } else {
        walker.next = second;
        second = second.next;
      }
      walker = walker.next;
    }

    if (first == null && second != null) {
      walker.next = second;
    }
    if (first != null && second == null) {
      walker.next = first;
    }
    return newHead.next;
  }



  public static void main(String[] args) {
    MergeTwoSortedLists m = new MergeTwoSortedLists();
    ListNode firstHead = new ListNode(1);
    firstHead.next = new ListNode(2);
    firstHead.next.next = new ListNode(3);

    ListNode secondHead = new ListNode(1);
//    secondHead.next = new ListNode(2);
//    secondHead.next.next = new ListNode(3);

    ListNode newHead = m.mergeTwoLists(firstHead, secondHead);
    newHead.print();
  }
}
