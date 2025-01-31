package stack;

class twoStacks {
    int t1, t2;
    int[] arr;
    int size;

    twoStacks() {
        size = 200;
        arr = new int[size];
        t1 = -1;
        t2 = size;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        // code here
        t1++;
        if(t1 == t2) {
            t1--;
        } else {
            arr[t1] = x;
        }
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        // code here
        t2--;
        if(t1 == t2) {
            t2++;
        } else {
            arr[t2] = x;
        }
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        // code here
        if(t1 == -1) {
            return -1;
        }
        int top = arr[t1];
        t1--;
        return top;
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        // code here
        if(t2 == size) {
            return -1;
        }
        int top = arr[t2];
        t2++;
        return top;
    }
}
