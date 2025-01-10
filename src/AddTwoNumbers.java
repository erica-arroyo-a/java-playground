import java.math.BigInteger;
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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        ListNode l3 = new ListNode();

        while(l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }
        BigInteger num1 = new BigInteger(sb1.reverse().toString());

        while(l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }
        BigInteger num2 = new BigInteger(sb2.reverse().toString());

        BigInteger total = num1.add(num2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(total);
        sb3.reverse();

        int headVal = Character.getNumericValue(sb3.charAt(0));
        ListNode head = new ListNode(headVal);
        l3 = head;

        for (int i = 1; i < sb3.length(); i++) {
            l3.next = new ListNode();
            l3 = l3.next;
            l3.val = Character.getNumericValue(sb3.charAt(i));
        }

        return head;
    }
}

