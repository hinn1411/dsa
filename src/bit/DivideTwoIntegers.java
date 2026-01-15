package bit;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {

      if (dividend == Integer.MIN_VALUE && divisor == -1) {
        return Integer.MAX_VALUE;
      }
      long absDividend = Math.abs((long)dividend);
      long absDivisor = Math.abs((long)divisor);

      if (absDividend < absDivisor) {
        return 0;
      }
      boolean isQuotientNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
      if (absDivisor == 1) {
        if (isQuotientNegative) {
          return -(int)absDividend;
        } else {
          return (int)absDividend;
        }
      }
      int quotient = 0;
      while (absDividend >= absDivisor) {
        absDividend -= absDivisor;
        quotient++;
      }

      if (isQuotientNegative) {
        return -quotient;
      } else {
        return quotient;
      }
  }
  public static void main(String[] args) {
    DivideTwoIntegers d = new DivideTwoIntegers();
    System.out.println(d.divide(10, 3));
    System.out.println(d.divide(7, -3));
    System.out.println(d.divide((int) Math.pow(2, 31) - 1, 1));
    System.out.println(d.divide((int) Math.pow(2, 31) - 1, -1));
    System.out.println(d.divide(-(int) Math.pow(2, 31), 1));
    System.out.println(d.divide(-(int) Math.pow(2, 31), -1));
    System.out.println(d.divide(2, 2));
    System.out.println(d.divide(2, -2));
    System.out.println(d.divide(-2147483648, -1));
  }
}
