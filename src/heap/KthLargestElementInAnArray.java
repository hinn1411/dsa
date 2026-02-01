package heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for (int num : nums) {
      q.add(num);
      if (q.size() > k) {
        q.poll();
      }
    }

    return q.peek();
  }

  public static void main(String[] args) {

  }
}
