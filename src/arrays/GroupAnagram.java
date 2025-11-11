package arrays;

import java.util.*;

public class GroupAnagram {

  public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> fre = new HashMap<>();
    for (String str: strs) {
      String sortedStr = getSortedString(str);
      if (!fre.containsKey(sortedStr)) {
        fre.put(sortedStr, new ArrayList<>());
      }
      fre.get(sortedStr).add(str);
    }

    return fre.values().stream().toList();
  }

  private String getSortedString(String s) {
    char[] tmp = s.toCharArray();
    Arrays.sort(tmp);
    return new String(tmp);
  }

  public static void main(String[] args) {
    GroupAnagram g = new GroupAnagram();
    var r1 = g.groupAnagrams(new String[]{"abc", "bca", "cab", "bat", "hien", "neih"});
    var r2 = g.groupAnagrams(new String[]{""});
    System.out.println(r1);
    System.out.println(r2);
  }
}
