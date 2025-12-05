package two_pointers;

import java.util.Arrays;

public class PermutationInString {

  public boolean checkInclusion(String s1, String s2) {
    String shortStr = s1, longStr = s2;
    if (shortStr.length() > longStr.length()) {
      return false;
    }
    int[] compareFre = new int[26];
    for (int i = 0; i < shortStr.length(); i++) {
      int curIndex = shortStr.charAt(i) - 'a';
      compareFre[curIndex]++;
    }

    int windowSize = shortStr.length();
    int[] baseFre = new int[26];
    for (int i = 0; i < longStr.length(); i++) {
      int endIndex = longStr.charAt(i) - 'a';
      baseFre[endIndex]++;
      if (i >= windowSize) {
        int startIndex = longStr.charAt(i - windowSize) - 'a';
        baseFre[startIndex]--;
      }
      if (isFrequencyMatch(baseFre, compareFre)) {
        return true;
      }
    }
    return false;
  }

  private boolean isFrequencyMatch(int[] base, int[] compare) {
    return Arrays.equals(base, compare);
  }

  public static void main(String[] args) {
    PermutationInString p = new PermutationInString();
    System.out.println(p.checkInclusion("ab", "eidbaooo")); // true
    System.out.println(p.checkInclusion("ab", "eidboaoo")); // false
  }
}
