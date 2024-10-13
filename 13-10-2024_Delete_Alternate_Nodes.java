class Solution {
    public void deleteAlt(Node head) {
        if (head == null) return;

        Node prev = head;
        Node node = head.next;

        while (prev != null && node != null) {
            prev.next = node.next;
            node = prev.next;
            if (node != null) {
                prev = node;
                node = node.next;
            }
        }
    }
}
