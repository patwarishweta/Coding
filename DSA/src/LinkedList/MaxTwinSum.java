package LinkedList;

/*
Intuition
Reverse the first half of the link list, then find maximum sum of each pair in two halfs.

Approach
Use fast-slow pointer to determine the middle point of link list, meanwhile reverse the first half by tracking slow pointer. While loop until the fast pointer reaches null. After that, we will get starting point of first half is prev and starting point of second half is slow

Complexity
Time complexity:
O(n)

Space complexity:
O(1)
* */
public class MaxTwinSum {
    public int pairSum(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        ListNode tail = head;
        while(tail != null && tail.next != null) {
            tail = tail.next.next;
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        int max = 0;
        while(prev != null) {
            max = Math.max(max, (prev.val+current.val));
            prev = prev.next;
            current = current.next;
        }
        return max;
    }
}
