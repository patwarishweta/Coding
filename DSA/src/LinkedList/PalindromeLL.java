package LinkedList;

/*
Reverse the first half of the LL while finding the mid with the help of slow and fast pointers.
slow and fast both are initialized to point to the head.
fast : 1st --- 3rd ---- 5th ---- 7th ----
slow : 1st --- 2nd ---- 3rd ---- 4th ----
Then compare the reversed first half with the second half.
* */
public class PalindromeLL {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

/*       For odd length linked list, slow would reach the mid while fast points to the last node of the list.
                - The first half is reversed and prev points to the head of the reversed list, slow points to the mid.
                - Here, mid is same and equal for the first half and the second half, hence we can skip the middle slow = slow.next.
                - Now, slow points to the head of the later half and prev points to the head of the first half(reversed)
                - Compare.
        For even length linked list, slow would reach the mid while fast is null.
                - The first half is reversed and prev points to the head of the reversed list, slow points to the mid.
                - Now, slow points to the head of the later half and prev points to the head of the first half(reversed)
                - Compare.
*/
        if(fast !=null)
            slow=slow.next;

        while(slow != null && prev != null && slow.val == prev.val) {
            slow = slow.next;
            prev = prev.next;
        }

        if(slow == null && prev == null)
            return true;

        return false;

    }
}
