package heap;

import java.util.*;

public class TaskScheduler {

  public static class Task {
    public char name;
    public int count;
    public int readyTime;
    public Task(char name, int count, int readyTime) {
      this.name = name;
      this.count = count;
      this.readyTime = readyTime;
    }
  }

  public int leastInterval(char[] tasks, int n) {
    if (n < 1) {
      return tasks.length;
    }
    Map<Character, Integer> taskFre = new HashMap<>();
    for (char task: tasks) {
      taskFre.put(task, taskFre.getOrDefault(task, 0) + 1);
    }
    PriorityQueue<Task> q = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
    for (var entry: taskFre.entrySet()) {
      q.add(new Task(entry.getKey(), entry.getValue(), 0));
    }

    int currentTime = 0;
    Deque<Task> cooldown = new ArrayDeque<>();
    while(!q.isEmpty() || !cooldown.isEmpty()) {
      currentTime++;
      while (!cooldown.isEmpty() && cooldown.peek().readyTime <= currentTime) {
        Task readyTask = cooldown.poll();
        q.add(readyTask);
      }
      if (!q.isEmpty()) {
        Task current = q.poll();
        current.count--;
        current.readyTime = currentTime + n + 1;
        if (current.count > 0) {
          cooldown.addLast(current);
        }
      }
    }
    return  currentTime;
  }
  public static void main(String[] args) {
    TaskScheduler t = new TaskScheduler();
    System.out.println(t.leastInterval(new char[]{'A','A','A','B','B','B'}, 2)); // 8
//    System.out.println(t.leastInterval(new char[]{'A','C','A','B','D','B'}, 1)); // 6
//    System.out.println(t.leastInterval(new char[]{'A','A','A', 'B','B','B'}, 3)); // 10
//    System.out.println(t.leastInterval(new char[]{'A','A','A'}, 1)); // 5
//    System.out.println(t.leastInterval(new char[]{'B','C','D','A','A','A','A','G'}, 1)); // 8
  }
}
