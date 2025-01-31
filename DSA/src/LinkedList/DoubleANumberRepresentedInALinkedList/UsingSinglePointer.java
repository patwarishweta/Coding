package LinkedList.DoubleANumberRepresentedInALinkedList;

import LinkedList.ListNode;

public class UsingSinglePointer {
    public ListNode doubleIt(ListNode head) {
        ListNode current = head;
        ListNode res;

        int value = 0;

        if(head.val > 4) {
            ListNode newNode = new ListNode(0, head);
            newNode.next = head;
            head = newNode;
            current = head;
        }

        res = head;
        int carry = 0;
        while(current.next != null) {
            value = current.next.val * 2;
            if(value > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            current.val = (current.val * 2 + carry) % 10;
            current = current.next;
        }

        current.val = (current.val * 2) % 10;

        return res;
    }
}
