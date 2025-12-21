package binary_search;

public class SearchInRotatedSortedArray {

  public int search(int[] nums, int target) {
    int n = nums.length;
    int left = 0, right = n - 1, mid;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
          if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
//    System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
//    System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
//    System.out.println(s.search(new int[]{1}, 0)); // -1
//    System.out.println(s.search(new int[]{1}, 1)); // 0
//    System.out.println(s.search(new int[]{4,5,6,7,8,1,2,3}, 8)); // 4
    System.out.println(s.search(new int[]{3, 1}, 1)); // 1
  }
}
