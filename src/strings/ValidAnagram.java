package strings;

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

  public static void main(String[] args) {
    ValidAnagram v = new ValidAnagram();
    System.out.println(v.isAnagram("car", "rac"));
    System.out.println(v.isAnagram("car", "cxr"));
    System.out.println(v.isAnagram("ccr", "ccc"));
  }
}
