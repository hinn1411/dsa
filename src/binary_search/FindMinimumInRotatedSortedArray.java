package binary_search;

public class FindMinimumInRotatedSortedArray {


  public int findMin(int[] nums) {
    int n = nums.length;
    int l = 0, r = n - 1;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] < nums[r]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return nums[l];
  }

  public static void main(String[] args) {
    FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
    System.out.println(f.findMin(new int[]{3,4,5,1,2}));
    System.out.println(f.findMin(new int[]{4,5,6,7,0,1,2}));
    System.out.println(f.findMin(new int[]{11,13,15,17}));
    System.out.println(f.findMin(new int[]{3,1,2}));
  }
}
