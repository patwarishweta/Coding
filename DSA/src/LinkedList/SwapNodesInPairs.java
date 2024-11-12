package LinkedList;

/*
Here we need to keep track of the current pair nodes, node previous to the pair.
DummyHead is a dummy pointer which keeps track of the swapped list and dummyHead.next is the head of the swapped list.
SwappedHead is used to point to the node previous to the node pair. It is used to connect the swapped pair(i, i+1) to the sub list(0, i-1)
prev points to the first node of the pair
current points to second node of the pair
next is used to hold the current->next temporarily
*/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode();
        ListNode swappedHead = dummyHead;
        ListNode prev = head;
        ListNode current = head.next;
        ListNode next;

        while(prev != null && current != null) {
            next = current.next;
            current.next = prev;
            prev.next = next;
            swappedHead.next = current;

            if(next == null || next.next == null)
                return dummyHead.next;

            swappedHead = prev;
            prev = next;
            current = next.next;
        }
        return dummyHead.next;
    }
}
