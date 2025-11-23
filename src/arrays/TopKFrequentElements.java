package arrays;

import java.util.*;

public class TopKFrequentElements {
  private static class Element {
    public final int value;
    public final int frequency;

    public Element(int value, int frequency) {
      this.value = value;
      this.frequency = frequency;
    }
  }
  // Build map: O(n) in time & O(n) in space
  // Build heap: O(mlogm) & O(m) in space
  // Extract element O(klogm)
  // Worst case: m = n -> O(nlogn) in time
  public int[] maxHeap(int[] nums, int k) {
    Map<Integer, Integer> freMap = new HashMap<>();
    for (int cur: nums) {
      freMap.put(cur, freMap.getOrDefault(cur, 0) + 1);
    }

    PriorityQueue<Element> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.frequency, a.frequency));

    for (Map.Entry<Integer, Integer> entry: freMap.entrySet()) {
      maxHeap.add(new Element(entry.getKey(), entry.getValue()));
    }

    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = maxHeap.poll().value;
    }
    return res;
  }

  // Build fre map: O(n)
  // Build heap: (2m - k)logk
  // Extracting result: k.logk
  public int[] minHeap(int[] nums, int k) {
    Map<Integer, Integer> freMap = new HashMap<>();
    for (int cur: nums) {
      freMap.put(cur, freMap.getOrDefault(cur, 0) + 1);
    }

    PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

    for (Map.Entry<Integer, Integer> entry: freMap.entrySet()) {
      minHeap.add(new Element(entry.getKey(), entry.getValue()));
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    return minHeap.stream().map(element -> element.value).mapToInt(Integer::intValue).toArray();

  }
  public static void main(String[] args) {
    TopKFrequentElements t = new TopKFrequentElements();
//    System.out.println(Arrays.toString(t.maxHeap(new int[]{1, 1, 1, 2, 2, 3}, 2))); // [1,2]
//    System.out.println(Arrays.toString(t.maxHeap(new int[]{1}, 1))); // [1]
//    System.out.println(Arrays.toString(t.maxHeap(new int[]{1,2,1,2,1,2,3,1,3,2}, 2))); // [1,2]

    System.out.println(Arrays.toString(t.minHeap(new int[]{1, 1, 1, 2, 2, 3}, 2))); // [1,2]
    System.out.println(Arrays.toString(t.minHeap(new int[]{1}, 1))); // [1]
    System.out.println(Arrays.toString(t.minHeap(new int[]{1,2,1,2,1,2,3,1,3,2}, 2))); // [1,2]
    System.out.println(Arrays.toString(t.minHeap(new int[]{1,1,1,1,1}, 1)));
  }
}
