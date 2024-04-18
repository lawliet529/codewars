import java.util.*;

public class Runes {

  public static int solveExpression(final String expression) {
    Set<Character> digitsToTry = new HashSet<>();
    for (char c = '0'; c <= '9'; c++) {
      digitsToTry.add(c);
    }

    int i = 1;
    while (!"+-*/".contains(expression.charAt(i) + "")) {
      digitsToTry.remove(expression.charAt(i));
      i++;
    }
    String num1 = expression.substring(0, i);
    char op = expression.charAt(i);
    int tmp = ++i;
    while (expression.charAt(i) != '=') {
      digitsToTry.remove(expression.charAt(i));
      i++;
    }
    String num2 = expression.substring(tmp, i);
    String num3 = expression.substring(i + 1);
    digitsToTry.removeAll(num3.chars().mapToObj(c -> (char) c).toList());
    if (num1.charAt(0) == '?' && num1.length() > 1
        || num2.charAt(0) == '?' && num2.length() > 1
        || num3.charAt(0) == '?' && num3.length() > 1
        || num1.charAt(0) == '-' && num1.charAt(1) == '?' && num1.length() > 2
        || num2.charAt(0) == '-' && num2.charAt(1) == '?' && num2.length() > 2
        || num3.charAt(0) == '-' && num3.charAt(1) == '?' && num3.length() > 2) {
      digitsToTry.remove('0');
    }

    for (char c : digitsToTry) {
      int int1 = Integer.parseInt(num1.replaceAll("\\?", c + ""));
      int int2 = Integer.parseInt(num2.replaceAll("\\?", c + ""));
      int int3 = Integer.parseInt(num3.replaceAll("\\?", c + ""));
      if (op == '+' && int1 + int2 == int3
          || op == '-' && int1 - int2 == int3
          || op == '*' && int1 * int2 == int3
          || op == '/' && int1 / int2 == int3) {
        return c - '0';
      }
    }

    return -1;
  }
}
