public static Node reverseDLL(Node  head){
    if(head.next == null) {
        return head;
    }
    Node current = head;
    Node temp = null;
    while(current != null) {
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;
        current = current.prev;
    }
    return temp.prev;
}
