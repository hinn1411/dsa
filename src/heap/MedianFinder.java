package heap;

import java.util.PriorityQueue;

public class MedianFinder {
  PriorityQueue<Integer> lower;
  PriorityQueue<Integer> upper;

  public MedianFinder() {
    lower = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    upper = new PriorityQueue<>();
  }

  public void addNum(int num) {
    lower.add(num);

    upper.add(lower.poll());

    if (upper.size() > lower.size()) {
      lower.add(upper.poll());
    }
  }

  public double findMedian() {
    int size = lower.size() + upper.size();
    if (size % 2 == 1) {
      return lower.peek();
    } else {
      return (lower.peek() + upper.peek()) / 2.0;
    }
  }

  public static void main(String[] args) {
    MedianFinder m = new MedianFinder();
    m.addNum(5);
    m.addNum(2);
//    m.addNum(8);
    m.addNum(3);
    System.out.println(m.findMedian());
  }
}
