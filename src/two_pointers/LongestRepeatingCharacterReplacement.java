package two_pointers;

public class LongestRepeatingCharacterReplacement {
  public int characterReplacement(String s, int k) {

    int[] fre = new int[26];
    int maxLen = 0, l = 0, maxFre = 0;
    for (int r = 0; r < s.length(); r++) {
      int curIndex = s.charAt(r) - 'A';
      fre[curIndex]++;
      maxFre = Math.max(maxFre, fre[curIndex]);
      int windowLen = r - l + 1;
      while (windowLen - maxFre > k) {
        int startIndex = s.charAt(l) - 'A';
        fre[startIndex]--;
        l++;
        windowLen = r - l + 1;
        maxFre = computeMaxFrequency(fre);
      }
      maxLen = Math.max(maxLen, windowLen);
    }
    return maxLen;
  }

  private int computeMaxFrequency(int[] fre) {
    int maxFre = 0;
    for (int f : fre) {
      maxFre = Math.max(maxFre, f);
    }
    return maxFre;
  }

  public static void main(String[] args) {
    LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
    System.out.println(l.characterReplacement("ABAB", 2));
    System.out.println(l.characterReplacement("AABABBA", 1));
  }
}
