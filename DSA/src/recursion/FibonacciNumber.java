package recursion;

/*
T/S : O(n2)/O(n)
* */
public class FibonacciNumber {
    public int fib(int n) {
        if(n <= 1)
            return n;

        return fib(n-1) + fib(n-2);
    }
}
