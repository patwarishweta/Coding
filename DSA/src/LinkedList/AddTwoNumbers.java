package LinkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode();
        ListNode head = res;
        int currentSum = 0;
        while(l1 != null && l2 != null) {
            ListNode newNode = new ListNode();
            currentSum = carry + l1.val + l2.val;
            newNode.val = currentSum % 10;
            carry = currentSum / 10;
            res.next = newNode;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            ListNode newNode = new ListNode();
            currentSum = carry + l1.val;
            newNode.val = currentSum % 10;
            carry = currentSum / 10;
            res.next = newNode;
            res = res.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            ListNode newNode = new ListNode();
            currentSum = carry + l2.val;
            newNode.val = currentSum % 10;
            carry = currentSum / 10;
            res.next = newNode;
            res = res.next;
            l2 = l2.next;
        }
        if(carry != 0) {
            ListNode newNode = new ListNode();
            newNode.val = carry;
            res.next = newNode;
        }
        return head.next;
    }
}
