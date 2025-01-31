package LinkedList.DoubleANumberRepresentedInALinkedList;

import LinkedList.ListNode;

public class UsingDoublePointer {
    public ListNode doubleIt(ListNode head) {
        ListNode prev = head;
        ListNode current = head;
        ListNode res;

        int value = 0;

        if(head.val > 4) {
            ListNode newNode = new ListNode(0, head);
            newNode.next = head;
            head = newNode;
            current = head;
            prev = head;
        }
        res = head;
        while(current != null) {
            value = current.val * 2;
            if(value > 9) {
                prev.val = prev.val + 1;
                current.val = value % 10;
            } else {
                current.val = value;
            }
            prev = current;
            current = current.next;
        }

        return res;
    }
}
