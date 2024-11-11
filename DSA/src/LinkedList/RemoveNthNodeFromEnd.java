package LinkedList;

/*
* Algorithm:
 1. Use two pointers (slow and fast), both starting at the head of the list.
 2. Move the fast pointer n steps ahead of the slow pointer.
 3. If after moving fast pointer n steps it reaches the end (null), it means the node to be removed is the head node.
 * Hence, return head.next.
 4. Move both pointers (slow and fast) simultaneously until fast reaches the end of the list.
 5. At this point, the slow pointer will be pointing to the node just before the node to be removed.
 * Adjust the next pointer of this node to skip the node to be deleted.
 6. Return the head of the modified list.
*
* Time complexity: O(n)
* Space complexity: O(1)
* */
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null) {
            return null;
        }

        ListNode fast = head;
        while(n != 0) {
            fast = fast.next;
            n--;
        }

        if(fast == null)
            return head.next;

        ListNode slow = head;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
