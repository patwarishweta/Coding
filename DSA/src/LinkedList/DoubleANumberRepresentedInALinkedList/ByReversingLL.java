package LinkedList.DoubleANumberRepresentedInALinkedList;

import LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ByReversingLL {
    public ListNode doubleIt(ListNode head) {
        //reverse the LL
        //multiply each digit with 2 and store in a new LL
        //reverse the new LL
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        int carry = 0;

        current = prev;
        ListNode res = new ListNode();
        ListNode resHead = res;

        while(current != null) {
            ListNode newNode = new ListNode();
            int currentVal = carry + (current.val * 2);
            newNode.val = currentVal % 10;
            carry = currentVal / 10;
            res.next = newNode;
            res = res.next;
            current = current.next;
        }

        if(carry != 0) {
            ListNode newNode = new ListNode();
            newNode.val = carry;
            res.next = newNode;
            res = res.next;
        }

        resHead = resHead.next;

        current = resHead;
        prev = null;
        next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}