import java.util.*;

class Solution {
    public void deleteNode(Node del_node) {
        if (del_node.next != null) {
            del_node.data = del_node.next.data;
            del_node.next = del_node.next.next;
        } else {
            del_node = null;
        }
    }
}
