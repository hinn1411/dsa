package stack;

import java.util.Objects;
import java.util.Stack;

public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stk = new Stack<>();

    for (String token: tokens) {
      if (Objects.isNull(token)) {
        continue;
      }

      if (!isOperator(token)) {
        stk.add(Integer.parseInt(token));
      } else {
        Integer second = stk.pop();
        Integer first = stk.pop();
        Integer result = compute(first, second, token);
        stk.add(result);
      }

    }
    return stk.peek();
  }

  private boolean isOperator(String s) {
    return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
  }

  private Integer compute(Integer first, Integer second, String operator) {
    return switch (operator) {
      case "+" -> first + second;
      case "-" -> first - second;
      case "*" -> first * second;
      case "/" -> first / second;
      default -> throw new IllegalStateException("Unexpected value: " + operator);
    };
  }
  public static void main(String[] args) {
    EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
    System.out.println(e.evalRPN(new String[]{"2","1","+","3","*"}));
    System.out.println(e.evalRPN(new String[]{"4","13","5","/","+"}));
    System.out.println(e.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
  }
}
