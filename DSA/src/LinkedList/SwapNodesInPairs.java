package LinkedList;

/*
Here we need to keep track of the current pair nodes, node previous to the pair.
DummyHead is a dummy pointer which keeps track of the swapped list and dummyHead.next is the head of the swapped list.
prev is used to point to the node previous to the node pair. It is used to connect the swapped pair(i, i+1) to the sub list(0, i-1)
current points to first node of the pair
next is used to hold the first node of the next pair(current->next->next) temporarily
*/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode();
        ListNode prev = dummyHead;
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            ListNode next = curr.next.next;
            ListNode second = curr.next;

            second.next = curr;
            curr.next = next;
            prev.next = second;

            prev = curr;
            curr = next;
        }
        return dummyHead.next;
    }
}
