package interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms2 {

  public static class Interval {
    public int start, end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public int minMeetingRooms(List<Interval> intervals) {
    intervals.sort((a, b) -> Integer.compare(a.start, b.start));
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int minRooms = 0;
    for(Interval curInterval: intervals) {
      while(!q.isEmpty() && q.peek() <= curInterval.start) {
        q.poll();
      }
      q.add(curInterval.end);
      minRooms = Math.max(minRooms, q.size());
    }
    return minRooms;
  }

  public static void main(String[] args) {
    MeetingRooms2 m = new MeetingRooms2();
    List<Interval> arr = new ArrayList<>();
    arr.add(new Interval(0, 40));
    arr.add(new Interval(5, 10));
    arr.add(new Interval(15, 20));
    System.out.println(m.minMeetingRooms(arr));
  }

}
