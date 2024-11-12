package LinkedList;

/*
1. Handle Edge Cases.
2. Compute Length.
3. Normalize k: Since rotating by k places is equivalent to rotating by k mod length, calculate the effective rotations needed.
4. Find the New Head: Calculate the new tail's position, which is at length - (k % length) - 1.
5. Traverse to this node and set its next to null, breaking the circular link.
Return the Result: The node after the new tail becomes the new head.
* */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;

        int size = 0;
        ListNode temp = head;

        while(temp != null) {
            size++;
            temp = temp.next;
        }

        k = k % size;

        if(k == 0)
            return head;

        ListNode fast = head;
        while(k != 0) {
            fast = fast.next;
            k--;
        }

        ListNode slow = head;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        head = newHead;
        return head;
    }
}
