package sliding_window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

  // TLE
  public int[] bruteForce(int[] nums, int k) {
    int n = nums.length;

    int[] maxWindow = new int[n - k + 1];
    for (int i = 0; i < n - k + 1; i++) {
      int currentWindow = Integer.MIN_VALUE;
      for (int j = i; j < i + k; j++) {
        currentWindow = Math.max(currentWindow, nums[j]);
      }
      maxWindow[i] = currentWindow;
    }
    return maxWindow;
  }

  public int[] maxHeap(int[] nums, int k) {
    int n = nums.length;

    int[] windows = new int[n - k + 1];
    PriorityQueue<int[]> pq = new PriorityQueue<>((first, second) -> second[0] - first[0]);
    for (int i = 0; i < n; i++) {
      pq.add(new int[]{nums[i], i});

      while (pq.peek()[1] <= i - k) {
        pq.poll();
      }
      if (i >= k - 1) {
        windows[i - k + 1] = pq.peek()[0];
      }
    }
    return windows;
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    Deque<Integer> dq = new ArrayDeque<>();
    int[] windows = new int[n - k + 1];

    for (int i = 0; i < n; i++) {

      while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
        dq.removeLast();
      }
      dq.addLast(i);
      if (i >= k - 1) {
        while (!dq.isEmpty() && dq.getFirst() <= i - k) {
          dq.removeFirst();
        }
        windows[i - k + 1] = nums[dq.getFirst()];
      }
    }
    return windows;
  }

  public static void main(String[] args) {
    SlidingWindowMaximum s = new SlidingWindowMaximum();
    System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1}, 1)));
  }
}
