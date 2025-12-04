package two_pointers;

public class ContainerWithMostWater {

  public int maxArea(int[] height) {
    int n = height.length;
    int max = Integer.MIN_VALUE;
    int l = 0, r = n - 1;
    int h, w;
    while (l < r) {
      h = Math.min(height[l], height[r]);
      w =  r - l;
      max = Math.max(max, h * w);
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    ContainerWithMostWater c = new ContainerWithMostWater();
    System.out.println(c.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    System.out.println(c.maxArea(new int[]{8,7,2,1}));
  }
}
