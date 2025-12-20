package stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
  class Car {
    int position;
    double time;
    public Car(int position, double time) {
      this.position = position;
      this.time = time;
    }
  }
  public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    Car[] cars = new Car[n];
    for (int i = 0; i < n; i++) {
      cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
    }
    Arrays.sort(cars, (first, second) -> second.position - first.position);
    double maxTime = 0;
    int fleetCount = 0;
    for (int i = 0; i < n; i++) {
      double currentTime = cars[i].time;
      if (currentTime > maxTime) {
        fleetCount++;
        maxTime = currentTime;
      }

    }
    return fleetCount;
  }
  public static void main(String[] args) {
    CarFleet c = new CarFleet();
    System.out.println(c.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
    System.out.println(c.carFleet(10, new int[]{3}, new int[]{3}));
    System.out.println(c.carFleet(100, new int[]{0,2,4}, new int[]{4,2,1}));
  }
}
