package arrays;

public class FindTheDuplicateNumber {

  public int findDuplicate(int[] nums) {
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      int idx = Math.abs(nums[i]);
      if (nums[idx] < 0) {
        return idx;
      }
       nums[idx] *= -1;
    }
    return -1;
  }

  public static void main(String[] args) {
    FindTheDuplicateNumber f = new FindTheDuplicateNumber();
    System.out.println(f.findDuplicate(new int[]{1,2,3,2,2}));
    System.out.println(f.findDuplicate(new int[]{1,2,3,4,4}));
    System.out.println(f.findDuplicate(new int[]{3,3,3,3,3}));
  }
}
