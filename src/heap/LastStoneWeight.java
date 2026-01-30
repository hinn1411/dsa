package heap;

import java.util.PriorityQueue;

public class LastStoneWeight {

  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b.compareTo(a));
    while (q.size() > 1) {
      int bigger = q.poll();
      int smaller = q.poll();
      if (bigger == smaller) {
        continue;
      }
      q.add(bigger - smaller);
    }

    return q.size() == 1 ? q.peek() : 0;
  }


  public static void main(String[] args) {
    LastStoneWeight l = new LastStoneWeight();
    System.out.println(l.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    System.out.println(l.lastStoneWeight(new int[]{1}));
    System.out.println(l.lastStoneWeight(new int[]{3, 3}));
  }
}
