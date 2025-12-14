package stack;

import java.util.*;

public class NextGreaterElementII {
  public int[] bruteForce(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      answer[i] = -1;
      for (int j = i; j < n; j++) {
        if (nums[j] > nums[i]) {
          answer[i] = nums[j];
          break;
        }
      }
      if (answer[i] == -1) {
        for (int j = 0; j < i; j++) {
          if (nums[j] > nums[i]) {
            answer[i] = nums[j];
            break;
          }
        }
      }
    }
    return answer;
  }

  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];
    Arrays.fill(answer, -1);
    Stack<Integer> stk = new Stack<>();
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      int current = nums[i];

      while (!stk.isEmpty() && current > nums[stk.peek()]) {
        answer[stk.peek()] = current;
        stk.pop();
      }
      stk.add(i);
      if (q.isEmpty() || current > q.peek()) {
        q.add(current);
      }
    }
    while (!stk.isEmpty()) {
      while (!q.isEmpty() && q.peek() <= nums[stk.peek()]) {
        q.remove();
      }
      if (q.isEmpty()) {
        break;
      }
      answer[stk.peek()] = q.peek();
      stk.pop();
    }

    return answer;
  }

  public static void main(String[] args) {
    NextGreaterElementII n = new NextGreaterElementII();
    System.out.println(Arrays.toString(n.nextGreaterElements(new int[]{1, 2, 1}))); // [2, -1, 2]
    System.out.println(Arrays.toString(n.nextGreaterElements(new int[]{1, 2, 3, 4, 3}))); // [2, 3, 4, -1, 4]
    System.out.println(Arrays.toString(n.nextGreaterElements(new int[]{3, 2, 1}))); // [-1, 3, 3]
    System.out.println(Arrays.toString(n.nextGreaterElements(new int[]{1, 1, 2, 1, 1}))); // [2, 2, -1, 2, 2]
  }
}
