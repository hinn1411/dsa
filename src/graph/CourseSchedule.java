package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adjList.add(new ArrayList<>());
    }
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      int destination = prerequisites[i][0], source = prerequisites[i][1];
      adjList.get(source).add(destination);
      inDegree[destination]++;
    }

    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }
    List<Integer> topoOrder = new ArrayList<>();
    while (!q.isEmpty()) {
      int current = q.poll();
      topoOrder.add(current);
      for (int i = 0; i <adjList.get(current).size(); i++) {
        int neighbor = adjList.get(current).get(i);
        inDegree[neighbor]--;
        if (inDegree[neighbor] == 0) {
          q.add(neighbor);
        }
      }

    }
    return topoOrder.size() == numCourses;
  }

  public static void main(String[] args) {
    CourseSchedule c = new CourseSchedule();
    int[][] normal = {{1, 0}};

    int[][] loop = {{1, 0}, {0, 1}};
    System.out.println(c.canFinish(2, normal));
    System.out.println(c.canFinish(2, loop));
  }
}
