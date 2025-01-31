import LinkedList.ListNode;
import LinkedList.ReverseLinkedListII;
import LinkedList.SwapNodesInPairs;
import Sorting.mergesort.SortArray;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//
//        ReverseLinkedListII obj = new ReverseLinkedListII();
//        obj.reverseBetween(head, 2, 4);

        SortArray sortArray = new SortArray();
        sortArray.sortArray(new int[]{5,4,3,2,1});
    }
}