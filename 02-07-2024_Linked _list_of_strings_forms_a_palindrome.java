class Solution {
    private boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean convertToString(Node head) {
        Node temp = head;
        StringBuilder str = new StringBuilder();
        while (temp != null) {
            str.append(temp.data);
            temp = temp.next;
        }
        return isPalindrome(str.toString());
    }

    public boolean compute(Node head) {
        return convertToString(head);
    }
}

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
