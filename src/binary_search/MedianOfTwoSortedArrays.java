package binary_search;

public class MedianOfTwoSortedArrays {
  public double mergeSort(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int[] sortedNums = new int[m + n];
    int medianIndex = (m + n) / 2;

    int i = 0, j = 0, k = 0;
    while (i < m && j < n) {
      if (nums2[j] > nums1[i]) {
        sortedNums[k] = nums1[i];
        k++;
        i++;
      } else {
        sortedNums[k] = nums2[j];
        k++;
        j++;
      }
    }
    while (i < m) {
      sortedNums[k] = nums1[i];
      k++;
      i++;
    }
    while(j < n) {
      sortedNums[k] = nums2[j];
      k++;
      j++;
    }
    if ((m + n) % 2 == 1) {
      return sortedNums[medianIndex];
    } else {
      return (sortedNums[medianIndex] + sortedNums[medianIndex - 1]) / 2.0;
    }
  }

  public static void main(String[] args) {
    MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
    System.out.println(m.mergeSort(new int[]{1,3}, new int[]{2}));
    System.out.println(m.mergeSort(new int[]{1,2}, new int[]{3,4}));
  }
}
