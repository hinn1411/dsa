package interval;

import java.util.List;

public class MeetingRooms {
  public class Interval {
    public int start, end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public boolean canAttendMeetings(List<Interval> intervals) {
    if (intervals.size() <= 1) {
      return true;
    }
    intervals.sort((a, b) -> Integer.compare(a.start, b.start));
    int n = intervals.size();
    for (int i = 0; i < n - 1; i++) {
      Interval former = intervals.get(i);
      Interval latter = intervals.get(i + 1);
      if (former.end > latter.start) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

  }
}
