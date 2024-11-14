package LinkedList;

public class RemoveLLElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        while(head != null) {
            if(head.val != val) {
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }

        current.next = null;

        return dummyHead.next;
    }
}
