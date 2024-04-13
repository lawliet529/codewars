import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  public static BigInteger fib(BigInteger n) {
    return fastDoubling(n, new HashMap<>());
  }

  public static BigInteger fastDoubling(BigInteger n, Map<Long, BigInteger> memo) {
    // break condition
    if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) return n;

    // some edge cases
    if (n.equals(BigInteger.TWO)) return BigInteger.ONE;
    if (n.equals(BigInteger.valueOf(-1L))) return BigInteger.ONE;

    // check memo
    if (memo.containsKey(n.longValue())) return memo.get(n.longValue());

    // find k so that n = 2k or n = 2k + 1
    BigInteger k = n.divide(BigInteger.TWO);
    if (n.compareTo(BigInteger.ZERO) < 0 && n.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
      k = n.subtract(BigInteger.ONE).divide(BigInteger.TWO);
    } else {
      k = n.divide(BigInteger.TWO);
    }
    BigInteger kPlus1 = k.add(BigInteger.ONE);

    // recursion
    if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
      // fib(2k) = f(k) * [2 * fib(k + 1) - fib(k)]
      memo.put(
          n.longValue(),
          fastDoubling(k, memo)
              .multiply(
                  BigInteger.TWO
                      .multiply(fastDoubling(kPlus1, memo))
                      .subtract(fastDoubling(k, memo))));
    } else {
      // fib(2k + 1) = fib(k)^2 + fib(k + 1)^2
      memo.put(n.longValue(), fastDoubling(k, memo).pow(2).add(fastDoubling(kPlus1, memo).pow(2)));
    }

    return memo.get(n.longValue());
  }
}
