package recursion;

/*
* T/S: O(logn)/O(logn)
* */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        if(n == 1)
            return true;
        return (n % 2 == 0 && isPowerOfTwo(n/2));
    }
}
