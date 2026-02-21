package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
  private Map<Character, char[]> phoneMap = buildPhoneMap();

  private Map<Character, char[]> buildPhoneMap() {
    Map<Character, char[]> phoneMap = new HashMap<>();
    phoneMap.put('2', new char[]{'a', 'b', 'c'});
    phoneMap.put('3', new char[]{'d', 'e', 'f'});
    phoneMap.put('4', new char[]{'g', 'h', 'i'});
    phoneMap.put('5', new char[]{'j', 'k', 'l'});
    phoneMap.put('6', new char[]{'m', 'n', 'o'});
    phoneMap.put('7', new char[]{'p', 'q', 'r', 's'});
    phoneMap.put('8', new char[]{'t', 'u', 'v'});
    phoneMap.put('9', new char[]{'w', 'x', 'y', 'z'});
    return phoneMap;
  }
  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();

    backtrack(digits, 0, new StringBuilder(), res);
    return res;
  }

  private void backtrack(String digits, int currentIndex, StringBuilder current, List<String> res) {
    if (current.length() == digits.length()) {
      res.add(current.toString());
      return;
    }

    for (char curChar: phoneMap.get(digits.charAt(currentIndex))) {
      current.append(curChar);
      backtrack(digits, currentIndex + 1, current, res);
      current.deleteCharAt(current.length() - 1);
    }
  }


  public static void main(String[] args) {
    LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
    System.out.println(l.letterCombinations("23"));
  }
}
