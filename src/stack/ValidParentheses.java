package stack;

import java.util.Stack;

public class ValidParentheses {
  public boolean isValid(String s) {
    int n = s.length();
    Stack<Character> stk = new Stack();
    for (int i = 0; i < n; i++) {
      char curChar = s.charAt(i);
      if (isOpen(curChar)) {
         stk.add(curChar);
      } else {
        if (stk.isEmpty()) {
          return false;
        }
        char openChar = stk.peek();
        char closedChar = curChar;
        if (!isMatch(openChar, closedChar)) {
          return false;
        }
        stk.pop();
      }
    }
    return stk.size() == 0;
  }

   private boolean isOpen(char c) {
    return c == '(' || c == '[' || c == '{';
   }
   private boolean isMatch(char openChar, char closedChar) {
    return (openChar == '(' && closedChar == ')')
        || (openChar == '[' && closedChar == ']')
        || (openChar == '{' && closedChar == '}');
   }
  public static void main(String[] args) {
    ValidParentheses v = new ValidParentheses();
    System.out.println(v.isValid("()")); // t
    System.out.println(v.isValid("[]{}()")); // t
    System.out.println(v.isValid("(]")); // f
    System.out.println(v.isValid("([])")); // t
    System.out.println(v.isValid("([)]")); // f
    System.out.println(v.isValid("((((")); // f
    System.out.println(v.isValid("))))")); // f
  }
}
