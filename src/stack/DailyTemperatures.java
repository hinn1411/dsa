package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
  public int[] bruteForce(int[] temperatures) {
    int n = temperatures.length;
    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      int currentTemperature = temperatures[i];
      int futureTemperature;
      for (int j = i; j < n; j++) {
        futureTemperature = temperatures[j];
        if (futureTemperature > currentTemperature) {
          answer[i] = j - i;
          break;
        }
      }
    }
    return answer;
  }

  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] answer = new int[n];
    Stack<int[]> stk = new Stack<>();
    for (int i = 0; i < n; i++) {
      int currentTemperature = temperatures[i];

      while (!stk.isEmpty() && currentTemperature > stk.peek()[0]) {
        answer[stk.peek()[1]] = i - stk.peek()[1];
        stk.pop();
      }
      stk.add(new int[]{currentTemperature, i});
    }
    return answer;
  }
  public static void main(String[] args) {
    DailyTemperatures d = new DailyTemperatures();
    System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{30,40,50,60})));
    System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{30,60,90})));
  }
}
