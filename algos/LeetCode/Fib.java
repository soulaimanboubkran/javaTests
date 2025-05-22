package algos.LeetCode;

import java.util.Map;

public class Fib {
      private static Map<Integer, Long> memoCache = new java.util.HashMap<>();
       public static long fibonacciMemoized(int n) {
        if (n <= 0) return -1;
        if (n == 1) return 0;
        if (n == 2) return 1;
        
        if (memoCache.containsKey(n)) {
            return memoCache.get(n);
        }
        
        long result = fibonacciMemoized(n - 1) + fibonacciMemoized(n - 2);
        memoCache.put(n, result);
        
        return result;
    }
}
