public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head, curr2 = head;
        int count = 0, count2 = 0;

        // go to the end of the list
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        if (n == count) return head.next;
        while (count2 < count - 1 - n) {
            curr2 = curr2.next;
            count2++;
        }
        curr2.next = curr2.next.next;

        return head;
    }
}
