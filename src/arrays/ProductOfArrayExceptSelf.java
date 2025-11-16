package arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {


  // TLE
  public int[] bruteForce(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];

    int res;
    for (int i = 0; i < n; i++) {
      res = 1;
      for (int j = 0; j < n; j++) {
        if (j != i) {
          res *= nums[j];
        }
      }
      answer[i] = res;
    }
    return answer;
  }
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int prefix = 1;
    int[] answer = new int[n];

    for (int i = 0; i < n; i++) {
      answer[i] = prefix;
      prefix = prefix * nums[i];
    }

    int suffix = 1;
    for (int i = n - 1; i >= 0; i--) {
      answer[i] = answer[i] * suffix;
      suffix = suffix * nums[i];
    }

    return answer;
  }

  public static void main(String[] args) {
    ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();

    System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1, 2, 3, 4})));
    System.out.println(Arrays.toString(p.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1, 2})));
    System.out.println("=== BRUTE FORCE ===");
    System.out.println(Arrays.toString(p.bruteForce(new int[]{1, 2, 3, 4})));
    System.out.println(Arrays.toString(p.bruteForce(new int[]{-1, 1, 0, -3, 3})));
    System.out.println(Arrays.toString(p.bruteForce(new int[]{1, 2})));
  }
}
