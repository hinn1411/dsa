package strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {
    int len = s.length();
    Map<Character, Character> sMap = new HashMap<>();
    Map<Character, Character> tMap = new HashMap<>();

    for (int i = 0; i < len; i++) {
      char cs = s.charAt(i);
      char ct = t.charAt(i);
      if (sMap.containsKey(cs)) {
        if (sMap.get(cs) != ct) {
          return false;
        }
      } else {
        if (tMap.containsKey(ct)) {
          return false;
        }
      }
      sMap.put(cs, ct);
      tMap.put(ct, cs);
    }
    return true;
  }

  public static void main(String[] args) {
    IsomorphicStrings i = new IsomorphicStrings();
    System.out.println(i.isIsomorphic("abc", "abc")); // true
    System.out.println(i.isIsomorphic("aaa", "bbb")); // true
    System.out.println(i.isIsomorphic("egg", "add")); // true
    System.out.println(i.isIsomorphic("abb", "bab")); // false
    System.out.println(i.isIsomorphic("paper", "title")); // true
    System.out.println(i.isIsomorphic("foo", "bar")); // false
    System.out.println(i.isIsomorphic("badc", "baba")); // false
  }
}
