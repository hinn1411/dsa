package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

  public int lengthOfLongestSubstring_D2(String s) {
    int res = 0, l = 0, len = s.length();
    Set<Character> seen = new HashSet<>();

    for (int r = 0; r < len; r++) {
      char cur = s.charAt(r);

      while(seen.contains(cur)) {
        char begin = s.charAt(l);
        seen.remove(begin);
        l++;
      }

      seen.add(cur);
      res = Math.max(res, r - l + 1);
    }
    return res;
  }

  public int lengthOfLongestSubstring_D7(String s) {
    int n = s.length();
    int maxLen = 0;
    int l = 0;
    Map<Character, Integer> seen = new HashMap<>();
    for (int r = 0; r < n; r++) {
      char cur = s.charAt(r);

      if (seen.containsKey(cur) && seen.get(cur) >= l) {
        l  = seen.get(cur) + 1;
      }

      maxLen = Math.max(maxLen, r - l + 1);
      seen.put(cur, r);
    }
    return maxLen;
  }
  public static void main (String[] args) {
    LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
    System.out.println(l.lengthOfLongestSubstring_D7("")); // 0
    System.out.println(l.lengthOfLongestSubstring_D7("a")); // 1
    System.out.println(l.lengthOfLongestSubstring_D7("aaaa")); // 1
    System.out.println(l.lengthOfLongestSubstring_D7("aabbcc")); // 2
    System.out.println(l.lengthOfLongestSubstring_D7("aabcad")); // 4
    System.out.println(l.lengthOfLongestSubstring_D7("abcdadefvdf")); // 5
  }
}
