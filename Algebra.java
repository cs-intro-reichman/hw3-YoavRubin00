// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  
	// Returns x1 + x2// Returns x1 + x2 (Corrected for negative x2)
public static int plus(int x1, int x2) {
    int ret = x1;
    if (x2 >= 0) {
        for (int i = 0; i < x2; i++) {
            ret++;
        }
    } else {
        int absX2 = minus(0, x2);
        for (int i = 0; i < absX2; i++) {
            ret--;
        }
    }
    return ret;
}

public static int minus(int x1, int x2) {
    return plus(x1, minus(0, x2));
}

public static int times(int x1, int x2) {
    if (x1 == 0 || x2 == 0) return 0;
    boolean isNegative = (x1 < 0) != (x2 < 0);
    int absX1 = x1 < 0 ? minus(0, x1) : x1;
    int absX2 = x2 < 0 ? minus(0, x2) : x2;
    int ret = 0;
    for (int i = 0; i < absX2; i++) {
        ret = plus(ret, absX1);
    }
    return isNegative ? minus(0, ret) : ret;
}

public static int pow(int x, int n) {
    if (n < 0) throw new IllegalArgumentException("n must be non-negative");
    if (n == 0) return 1; 
    int ret = x;
    for (int i = 0; i < minus(n, 1); i++) {
        ret = times(ret, x);
    }
    return ret;
}

public static int div(int x1, int x2) {
    if (x2 == 0) throw new IllegalArgumentException("Division by zero");
    int Cnt = 0;
    int ret = x1;
    while (ret >= x2) { 
        ret = minus(ret, x2);
        Cnt++;
    }
    return Cnt;
}
// Returns the integer part of sqrt(x) 
public static int sqrt(int x) {
    if (x < 0) {
        return -1;
    }
    if (x == 0 || x == 1) {
        return x;
    }
    int result = 0;
    while (true) {
        int next_x = plus(result, 1); 
        int next_square = times(next_x, next_x); 
        if (next_square > x) {
            break;
        }
        result++;
    }
    return result;
}
public static int mod(int x1, int x2) {
    int me = div(x1, x2); 
    int paid = times(me, x2);
    return minus(x1, paid); 
}

}