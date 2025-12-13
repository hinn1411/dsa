package stack;

import java.util.Stack;

public class MinStack {
  private Stack<Integer> internalStack;
  private Stack<Integer> descendingStack;

  public MinStack() {
    internalStack = new Stack<>();
    descendingStack = new Stack<>();
  }

  public void push(int val) {
    internalStack.push(val);
    if (descendingStack.isEmpty() || val <= descendingStack.peek()) {
      descendingStack.push(val);
    }
  }

  public void pop() {
    if (internalStack.isEmpty()) {
      return;
    }
    if (internalStack.peek().equals(descendingStack.peek())) {
      descendingStack.pop();
    }

    internalStack.pop();
  }

  public int top() {
    if (internalStack.isEmpty()) {
      return -1;
    }
    return internalStack.peek();
  }

  public int getMin() {
    if (descendingStack.isEmpty()) {
      return - 1;
    }
    return descendingStack.peek();
  }

  public static void main(String[] args) {
    MinStack m = new MinStack();
    m.push(1);
    m.push(1);
    m.push(2);
    m.push(1);
    System.out.println(m.getMin()); // 1
    m.pop();
    System.out.println(m.top()); // 2
    System.out.println(m.getMin()); // 1
    m.pop();
    System.out.println(m.getMin()); // 1
  }
}
