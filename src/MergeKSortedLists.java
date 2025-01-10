public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode temp = new ListNode(-1);
        ListNode prev = temp;

        while (true) {
            ListNode min = null;
            int minIndex = -1;

            for (int i = 0; i < lists.length; i++) {
                ListNode curr = lists[i];
                if (curr == null) continue;
                if (min == null || curr.val < min.val) {
                    min = curr;
                    minIndex = i;
                }
            }
            if (min == null) break;

            prev.next = min;
            prev = prev.next;

            lists[minIndex] = min.next;
        }

        return temp.next;
    }
}
