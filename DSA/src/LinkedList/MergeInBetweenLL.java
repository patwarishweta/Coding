package LinkedList;

/*
* Algorithm
Initialize two ListNodes, start to null and end to list1.
Find the nodes at index a - 1 and b of list1. Traverse through list1 using a for loop with the iterator index from 0 to b - 1:
If index equals a - 1 set start to end.
Progress to the next node in list1 by setting end to end.next.
Set start.next to list2.
Find the tail of list2 by traversing the list with list2 = list2.next until the last node is reached.
Set list2.next to end.next and set end.next to null. Note that the order of the statements is important.
Return list1, which points to the head of the resultant linked list.
*
* Time complexity: O(n+m)
* Space complexity: O(1)
* */

public class MergeInBetweenLL {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aPrev = null;
        ListNode bNext = list1;

        for (int index = 0; index < b; index++) {
            if (index == a - 1) {
                aPrev = bNext;
            }
            bNext = bNext.next;
        }

        aPrev.next = list2;

        while(list2.next != null) {
            list2 = list2.next;
        }

        list2.next = bNext.next;
        return list1;
    }
}
