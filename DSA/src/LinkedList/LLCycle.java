package LinkedList;

/*
1. Initialize fast and slow pointers to the head of the linked list.

2. fast and slow are initially pointing to the head, head.next of the linked list, which is the starting point.
Enter a loop while both fast and fast.next are not null.

3. This loop will continue until either fast or fast.next becomes null or fast == slow, indicating the end of the linked list or if there is no cycle.
Move the fast pointer two steps ahead (fast = fast.next.next) and the slow pointer one step ahead (slow = slow.next).

4. This step simulates the two-pointer traversal where fast moves twice as fast as slow.
5. Check if fast is equal to slow.

6. If fast and slow pointers meet at the same node, it means there is a cycle in the linked list, and we return True.
7. If the loop exits without finding a cycle, return False.

8. If the loop completes without finding a cycle, it means that the fast pointer has reached the end of the list, and there is no cycle. In this case, we return False.
* */
public class LLCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow == fast)
            return true;

        return false;
    }
}
