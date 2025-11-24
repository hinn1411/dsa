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

  public boolean isIsomorphic_D2(String s, String t) {
    int n = s.length(), m = t.length();
    if (n != m) {
      return false;
    }
    final int MAX_SIZE = 256;

    int[] sMap = new int[MAX_SIZE], tMap = new int[MAX_SIZE];

    for (int i = 0; i < n; i++) {
      char cs = s.charAt(i), ct = t.charAt(i);

      if (sMap[cs] != 0) {
        if (sMap[cs] != ct) {
          return false;
        }
      } else {
        if (tMap[ct] != 0) {
          return false;
        }
      }
      sMap[cs] = ct;
      tMap[ct] = cs;
    }
    return true;
  }

  public boolean isIsomorphic_D7(String s, String t) {
    int m = s.length(), n = t.length();
    if (m != n) {
      return true;
    }

    Map<Character, Character> sToT = new HashMap<>();
    Map<Character, Character> tToS = new HashMap<>();

    for (int i = 0; i < m; i++) {
      char curS = s.charAt(i), curT = t.charAt(i);

      if (sToT.get(curS) == null) {
        if(tToS.get(curT) != null) {
          return false;
        }
      } else {
        if (curT != sToT.get(curS)) {
          return false;
        }
      }

      sToT.put(curS, curT);
      tToS.put(curT, curS);
    }
    return true;
  }

  public static void main(String[] args) {
    IsomorphicStrings i = new IsomorphicStrings();
    System.out.println(i.isIsomorphic_D7("abc", "abc")); // true
    System.out.println(i.isIsomorphic_D7("aaa", "bbb")); // true
    System.out.println(i.isIsomorphic_D7("egg", "add")); // true
    System.out.println(i.isIsomorphic_D7("abb", "bab")); // false
    System.out.println(i.isIsomorphic_D7("paper", "title")); // true
    System.out.println(i.isIsomorphic_D7("foo", "bar")); // false
    System.out.println(i.isIsomorphic_D7("badc", "baba")); // false
  }
}
