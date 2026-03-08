package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adjList = new ArrayList<>();
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int i = 0; i < prerequisites.length; i++) {
      int source = prerequisites[i][1], destination = prerequisites[i][0];
      inDegree[destination]++;
      adjList.get(source).add(destination);
    }
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }
    List<Integer> topoOrder = new ArrayList<>();
    while(!q.isEmpty()) {
       int current = q.poll();
       topoOrder.add(current);
       for (int i = 0; i < adjList.get(current).size(); i++) {
         int neighbor = adjList.get(current).get(i);
         inDegree[neighbor]--;
         if (inDegree[neighbor] == 0) {
           q.add(neighbor);
         }
       }
    }
    return topoOrder.size() < numCourses ? new int[]{} : topoOrder.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {

  }
}
