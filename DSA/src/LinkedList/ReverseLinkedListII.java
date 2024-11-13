package LinkedList;

/*
1. Check for base cases.
If the linked list is empty (not head) or left is equal to right, return the original head as there is no reversal needed.

2. Initialize a dummy node to simplify edge cases and connect it to the head of the linked list.
Create a dummy node with a value of 0 and set its next pointer to the head of the linked list. This dummy node helps in handling the case when left is 1.

3. Traverse the list to find the (left-1)-th node.
    Initialize a start pointer to dummy.
    Loop left - 1 times to move the start pointer to the node just before the left-th node.

4. Reverse the portion of the linked list from the left-th node to the right-th node.
    Initialize a subStart pointer pointing to the left-th node of the sublist to be reversed.
    Initialize a cur pointer to start.next, and a prev pointer initialized with null
    Loop right - left times to reverse the direction of the pointers in this portion of the linked list:

5. Now current points to the node just after the right-th node and prev points to the right-th node.
    Update start.next to point to prev, making prev the new next node of starting node(left-th -1 node).
    Update subStart.next to point to the current node, reversing the sublist.

6. Return the new head of the modified linked list.

dummy.next points to the head of the modified linked list, so return dummy.next as the result.
* */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;

        for (int i = 0; i < left - 1; ++i) {
            start = start.next;
        }

        ListNode subStart = start.next;

        ListNode current = subStart;
        ListNode prev = null;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return dummy.next;
    }

    public ListNode anotherApproach(ListNode head, int left, int right) {
        /*
        Check for base cases.
            If the linked list is empty (not head) or left is equal to right, return the original head as there is no reversal needed.

        Initialize a dummy node to simplify edge cases and connect it to the head of the linked list.
            Create a dummy node with a value of 0 and set its next pointer to the head of the linked list. This dummy node helps in handling the case when left is 1.

        Traverse the list to find the (left-1)-th node.
            Initialize a prev pointer to dummy.
            Loop left - 1 times to move the prev pointer to the node just before the left-th node.

        Reverse the portion of the linked list from the left-th node to the right-th node.
            Initialize a cur pointer to prev.next.
            Loop right - left times to reverse the direction of the pointers in this portion of the linked list:
                Store the next node (temp) of cur to avoid losing the reference.
                Update the cur.next to point to temp.next, effectively reversing the direction.
                Move temp.next to point to prev.next, effectively moving temp to the correct position in the reversed portion.
                Update prev.next to point to temp, making temp the new next node of prev.

        Return the new head of the modified linked list.
            dummy.next points to the head of the modified linked list, so return dummy.next as the result.
        * */
        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; ++i) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for(int i = 0; i < right-left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
    }
}
