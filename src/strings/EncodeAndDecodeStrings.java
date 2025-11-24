package strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
  private static final char delimiter = ':';

  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      int curLen = str.length();
      sb.append(curLen).append(delimiter).append(str);
    }

    return sb.toString();
  }

  public List<String> decode(String str) {
    StringBuilder quantityBuilder = new StringBuilder();

    List<String> res = new ArrayList<>();
    int curIndex = 0;
    while (curIndex < str.length()) {
      char cur = str.charAt(curIndex);
      if (cur == delimiter) {
        curIndex++;
        int quantity = Integer.parseInt(quantityBuilder.toString());
        quantityBuilder.setLength(0);
        String origin = str.substring(curIndex, curIndex + quantity);
        res.add(origin);
        curIndex += quantity;
      } else {
        quantityBuilder.append(cur);
        curIndex++;
      }

    }
    return res;
  }

  public static void main(String[] args) {
    EncodeAndDecodeStrings e = new EncodeAndDecodeStrings();
    String encoded = e.encode(List.of("hien", "giang", "is", "super", "idolllllllllllllllllll"));
    System.out.println(e.decode(encoded));
  }
}
