package LinkedList;

/*
*
* The code merges two sorted linked lists by using a dummy node to simplify the merging process. Here's the short intuition:

Dummy Node: A dummy node is used to easily build the merged list, with current pointing to the last node in the merged list.
Traverse Both Lists: Compare the current values of list1 and list2. Append the smaller value to the merged list,
and move the pointer of the corresponding list forward.
Append Remaining Nodes: Once one list is fully traversed, append the remaining nodes of the other list (since it’s already sorted).
Return Merged List: Return dummy.next as the head of the new merged list.
This ensures an efficient merge with time complexity of O(n + m), where n and m are the lengths of the two lists.

*  Time Complexity : O(n+m)
*  Space Complexity : O(1)
* */
public class MergeTwoSortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 == null)
            current.next = list2;

        if(list2 == null)
            current.next = list1;

        return dummy.next;

    }
}
