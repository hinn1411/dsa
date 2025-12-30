package binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
  static class TimeMap {
    HashMap<String, TimeValue> store;

    private class TimeValue {
      public List<Integer> timestamps;
      public List<String> values;

      public TimeValue() {
        this.timestamps = new ArrayList<>();
        this.values = new ArrayList<>();
      }
    }

    public TimeMap() {
      this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
      if (!store.containsKey(key)) {
        store.put(key, new TimeValue());
      }
      store.get(key).timestamps.add(timestamp);
      store.get(key).values.add(value);
    }

    public String get(String key, int timestamp) {
      if (!store.containsKey(key)) {
        return "";
      }
      List<Integer> timestamps = store.get(key).timestamps;
      List<String> values = store.get(key).values;
      int index = searchTimestamp(timestamps, timestamp);
      if (index < 0) {
        return "";
      }
      return values.get(index);
    }

    private int searchTimestamp(List<Integer> nums, int target) {
      int n = nums.size();

      int l = 0, r = n - 1;
      while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums.get(mid) <= target) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      return r;
    }
  }

  public static void main(String[] args) {
    TimeMap t = new TimeMap();
    t.set("foo", "bar", 1);
    System.out.println(t.get("foo", 1));
    System.out.println(t.get("foo", 3));
    t.set("foo", "bar2", 4);
    System.out.println(t.get("foo", 4));
    System.out.println(t.get("foo", 5));
  }
}
