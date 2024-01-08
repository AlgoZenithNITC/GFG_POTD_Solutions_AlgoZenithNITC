class GfG{
  Node mergeResult(Node node1, Node node2){
	if(node1 == null && node2 == null) {
            return null;
        }
        
        Node present = null;
        
        while (node1 != null && node2 != null) {
            if (node1.data <= node2.data) {
                Node temp = node1.next;
                node1.next = present;
                present = node1;
                node1 = temp;
            } else {
                Node temp = node2.next;
                node2.next = present;
                present = node2;
                node2 = temp;
            }
        }
        
        while (node1 != null) {
            Node temp = node1.next;
            node1.next = present;
            present = node1;
            node1 = temp;
        }
        
        while (node2 != null) {
            Node temp = node2.next;
            node2.next = present;
            present = node2;
            node2 = temp;
        }
        
        return present;
    }
}
