package binary_search;

public class BinarySearch {

  public int search(int[] nums, int target) {
    int n = nums.length;
    int left = 0, right = n - 1, mid;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    BinarySearch b = new BinarySearch();
    System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 9)); // 4
    System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 2)); // -1
    System.out.println(b.search(new int[]{5}, 5)); // 0
  }
}
