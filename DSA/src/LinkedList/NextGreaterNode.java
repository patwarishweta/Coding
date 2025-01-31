package LinkedList;

import java.util.ArrayList;
import java.util.Stack;

/*
Algorithm
Traverse through the linked list head, and use an array values to store the values of nodes.
Initialize an array answer with the same size as values and an empty stack stack to store the previous indexes.
Iterate over values, before we push each index i to stack:
If the value represented by the top element of stack (let's call it values[smaller]) is smaller than values[i], it means that values[i] is values[smaller]'s larger value. So we pop smaller from the stack, update answer[smaller] = values[i] and repeat this step.
Otherwise, it means there is no value smaller than values[i], we add values[i] to stack and repeat step 3.
* */
public class NextGreaterNode {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> nums = new ArrayList<>();

        if(head.next == null) {
            return new int[]{0};
        }

        ListNode temp = head;

        while(temp != null) {
            nums.add(temp.val);
            temp = temp.next;
        }

        int index = 0;
        int[] nextLargerNum = new int[nums.size()];
        stack.push(index);
        index++;


        while(index < nums.size()) {
            int top = stack.peek();
            if(nums.get(index) > nums.get(top)) {
                while(!stack.isEmpty() && nums.get(index) > nums.get(stack.peek())) {
                    nextLargerNum[stack.peek()] = nums.get(index);
                    stack.pop();
                }
            }
            stack.push(index);
            index++;
        }
        return nextLargerNum;
    }
}
