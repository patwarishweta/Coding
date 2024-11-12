package LinkedList;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode current = head.next;

        while(current != null) {
            if(prev.val != current.val) {
                prev.next = current;
                prev = current;
                current = current.next;
            } else {
                current = current.next;
            }
        }
        prev.next = null;
        return head;
    }
}
