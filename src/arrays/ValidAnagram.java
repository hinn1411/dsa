package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnagram {

  public boolean isAnagram(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    if (sLen != tLen) {
      return false;
    }

    Map<Character, Integer> sMap = new HashMap<>();
    Map<Character, Integer> tMap = new HashMap<>();

    int len = s.length();
    for (int i = 0; i < len; i++) {
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
      tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
    }

    for (char c : sMap.keySet()) {
      if (!Objects.equals(sMap.get(c),(tMap.get(c)))) {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagram_D2(String s, String t) {
    int n = s.length(), m = t.length();
    if (n != m) {
      return false;
    }
    int[] sFre = new int[256], tFre = new int[256];
    for (int i = 0; i < n; i++) {
      char cs = s.charAt(i), ct = t.charAt(i);
      sFre[cs]++;
      tFre[ct]++;
    }

    for (int i = 0; i < 256; i++) {
      if (sFre[i] != tFre[i]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    ValidAnagram v = new ValidAnagram();
    System.out.println(v.isAnagram_D2("car", "rac"));
    System.out.println(v.isAnagram_D2("car", "cxr"));
    System.out.println(v.isAnagram_D2("ccr", "ccc"));
  }
}
