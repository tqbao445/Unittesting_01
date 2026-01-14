
package com.tqbao.mathutility.core;

public class MathUtil {
    public static long getFactorial(int n) {
        if(n < 0 || n > 20)
            throw new IllegalArgumentException("Invalid argument. n must be bewteen 0 to 20");
        if(n == 0 || n == 1)
            return 1;
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
