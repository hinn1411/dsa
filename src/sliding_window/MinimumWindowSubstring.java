package sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {

  public String bruteForce(String s, String t) {
    int m = s.length(), n = t.length();
    if (n > m) {
      return "";
    }

    Map<Character, Integer> tFre = new HashMap<>();

    for (int i = 0; i < n; i++) {
      char current = t.charAt(i);
      tFre.put(current, tFre.getOrDefault(current, 0) + 1);
    }

    int minLen = Integer.MAX_VALUE;
    String answer = "";
    for (int i = 0; i < m; i++) {
      Map<Character, Integer> winFre = new HashMap<>();
      for (int j = i; j < m; j++) {
        char c = s.charAt(j);
        winFre.put(c, winFre.getOrDefault(c, 0) + 1);
        if (covers(winFre, tFre)) {
          int currentLen = j - i + 1;
          if (currentLen < minLen) {
            minLen = currentLen;
            answer = s.substring(i, j + 1);
            break;
          }
        }
      }
    }
    return answer;
  }

  private boolean covers(Map<Character, Integer> windowFre, Map<Character, Integer> tFre) {
    for (char c: tFre.keySet()) {
      int sc = windowFre.getOrDefault(c, 0);
      int tc = tFre.get(c);
      if (sc < tc) {
        return false;
      }
    }
    return true;
  }

  public String minWindow(String s, String t) {
    int m = s.length(), n = t.length();
    if (n > m) {
      return "";
    }

    Map<Character, Integer> need = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char cur = t.charAt(i);
      need.put(cur, need.getOrDefault(cur, 0) + 1);
    }

    int l = 0, formed = 0, required = need.size();
    Map<Character, Integer> window = new HashMap<>();
    int bestLen = Integer.MAX_VALUE, bestL = 0;

    for (int r = 0; r < m; r++) {
      char cur = s.charAt(r);
      window.put(cur, window.getOrDefault(cur, 0) + 1);
      if (Objects.equals(window.get(cur), need.getOrDefault(cur, 0))) {
        formed++;
      }

      while (formed == required) {

        if (r - l + 1 < bestLen) {
          bestL = l;
          bestLen = r - l + 1;
        }
        char leftChar = s.charAt(l);
        window.put(leftChar, window.get(leftChar) - 1);
        if (window.get(leftChar) < need.getOrDefault(leftChar, 0)) {
          formed--;
        }
        l++;
      }
    }

    if (bestLen == Integer.MAX_VALUE) {
      return "";
    }

    return s.substring(bestL, bestL + bestLen);

  }

  public String bruteForceD2(String s, String t) {
    int m = s.length(), n = t.length();
    if (n > m) {
      return "";
    }

    Map<Character, Integer> requiredFre = new HashMap<>();
    for (char cur : t.toCharArray()) {
      requiredFre.put(cur, requiredFre.getOrDefault(cur, 0) + 1);
    }

    int minLen = Integer.MAX_VALUE;
    String res = "";
    for (int i = 0; i < m; i++) {
      Map<Character, Integer> curFre = new HashMap<>();
      for (int j = i; j < m; j++) {
        char curChar = s.charAt(j);
        curFre.put(curChar, curFre.getOrDefault(curChar, 0) + 1);
        if (coversD2(curFre, requiredFre)) {
          int curLen = j - i + 1;
          if (curLen < minLen) {
            minLen = curLen;
            res = s.substring(i, j + 1);
          }
          break;
        }
      }

    }
    return res;
  }

  private boolean coversD2(Map<Character, Integer> curFre, Map<Character, Integer> requiredFre) {
    for (char cur : requiredFre.keySet()) {
      if (curFre.getOrDefault(cur, 0) < requiredFre.get(cur)) {
        return false;
      }
    }
    return true;
  }

  public String minWindowD2(String s, String t) {

    Map<Character, Integer> requiredFre = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char curChar = t.charAt(i);
      requiredFre.put(curChar, requiredFre.getOrDefault(curChar, 0) + 1);
    }
    int requiredChars = requiredFre.size();
    int formedChars = 0;
    int bestLeft = 0;
    int minLen = Integer.MAX_VALUE;
    Map<Character, Integer> currentFre = new HashMap<>();
    int l = 0;
    for (int r = 0; r < s.length(); r++) {
      char curChar = s.charAt(r);
      currentFre.put(curChar, currentFre.getOrDefault(curChar, 0) + 1);
      if (Objects.equals(currentFre.get(curChar)
          , requiredFre.getOrDefault(curChar, 0))) {
        formedChars++;
      }

      while (formedChars == requiredChars) {
        char headChar = s.charAt(l);
        if (currentFre.get(headChar).equals(requiredFre.get(headChar))) {
          formedChars--;
        }
        currentFre.put(headChar, currentFre.get(headChar) - 1);

        int currentLen = r - l + 1;
        if (currentLen < minLen) {
          minLen = currentLen;
          bestLeft = l;
        }
        l++;
      }
    }
    // s do not contain t
    if (minLen == Integer.MAX_VALUE) {
      return "";
    }
    // use bestLeft and minLen to avoid getting substring when we hit a valid one
    return s.substring(bestLeft, bestLeft + minLen);
  }

  public static void main(String[] args) {
    MinimumWindowSubstring m = new MinimumWindowSubstring();
    System.out.println(m.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
    System.out.println(m.minWindow("a", "a"));
    System.out.println(m.minWindow("a", "aa"));
    System.out.println(m.minWindow("aaa", "c"));

    System.out.println("===== BRUTE FORCE ====");
    System.out.println(m.minWindowD2("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    System.out.println(m.minWindowD2("ADOBECODEBANC", "ABC"));
    System.out.println(m.minWindowD2("a", "a"));
    System.out.println(m.minWindowD2("a", "aa"));
    System.out.println(m.minWindowD2("aaa", "c"));
  }
}
