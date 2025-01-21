class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode newHead = null;
        ListNode tail = null;

        while (current != null) {
            ListNode groupHead = current;
            ListNode prev = null;
            ListNode nextNode = null;
            int count = 0;

            // Reverse k nodes
            while (current != null && count < k) {
                nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
                count++;
            }

            if (newHead == null) {
                newHead = prev;
            }

            if (tail != null) {
                tail.next = prev;
            }

            tail = groupHead;
        }

        return newHead;
    }
}
