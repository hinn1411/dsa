package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    int n = s.length(), l = 0, maxLen = 0;
    Map<Character, Integer> seen = new HashMap<>();
    for (int r = 0; r < n; r++) {
      char current = s.charAt(r);
      int prevIndex = seen.getOrDefault(current, -1);
      if (prevIndex >= l) { // abcbad
        l = prevIndex + 1;
      }
      seen.put(current, r);
      maxLen = Math.max(maxLen, r - l + 1);
    }
    return maxLen;
  }
  public static void main (String[] args) {
    LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
//    System.out.println(l.lengthOfLongestSubstring(""));
//    System.out.println(l.lengthOfLongestSubstring("a"));
//    System.out.println(l.lengthOfLongestSubstring("aaaa"));
//    System.out.println(l.lengthOfLongestSubstring("aabbcc"));
    System.out.println(l.lengthOfLongestSubstring("aabcad"));
  }
}
