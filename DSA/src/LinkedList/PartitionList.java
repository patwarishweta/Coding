package LinkedList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;

        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();

        ListNode list1Head = list1;
        ListNode list2Head = list2;

        while(head != null) {
            if(head.val < x) {
                list1.next = head;
                list1 = list1.next;
            } else {
                list2.next = head;
                list2 = list2.next;
            }
            head = head.next;
        }

        list1.next = list2Head.next;
        list2.next = null;
        return list1Head.next;

    }
}
