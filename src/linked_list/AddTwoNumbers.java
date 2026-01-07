package linked_list;

import java.util.List;

public class AddTwoNumbers {
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

  public ListNode addTwoNumbers(ListNode first, ListNode second) {
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    ListNode firstHead = first, secondHead = second;
    int carrier = 0;
    while (firstHead != null && secondHead != null) {
      int curSum = firstHead.val + secondHead.val + carrier;
      carrier = curSum / 10;
      cur.next = new ListNode(curSum % 10);
      cur = cur.next;
      firstHead = firstHead.next;
      secondHead = secondHead.next;
    }

    while (firstHead != null) {
      int curSum = firstHead.val + carrier;
      carrier = curSum / 10;
      cur.next = new ListNode(curSum % 10);
      cur = cur.next;
      firstHead = firstHead.next;
    }

    while (secondHead != null) {
      int curSum = secondHead.val + carrier;
      carrier = curSum / 10;
      cur.next = new ListNode(curSum % 10);
      cur = cur.next;
      secondHead = secondHead.next;
    }

    if (carrier == 1) {
      cur.next = new ListNode(1);
      cur = cur.next;
    }


    return dummy.next;

  }

  public ListNode addTwoNumbers_Refactored(ListNode first, ListNode second) {
    int carrier = 0;
    ListNode dummy = new ListNode();
    ListNode cur = dummy;

    while (first != null || second != null || carrier != 0) {
      int sum = carrier;
      if (first != null) {
        sum += first.val;
        first = first.next;
      }

      if (second != null) {
         sum += second.val;
         second = second.next;
      }

      cur.next = new ListNode(sum % 10);
      cur = cur.next;
      carrier = sum / 10;

    }

    return dummy.next;

  }

  public static void main(String[] args) {
    ListNode first = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode second = new ListNode(5, new ListNode(6, new ListNode(4)));
    AddTwoNumbers a = new AddTwoNumbers();
    ListNode result = a.addTwoNumbers_Refactored(first, second);
    result.print();
  }
}
