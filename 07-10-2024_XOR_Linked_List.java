

// class Node {
//     int data;
//     Node npx;

//     Node(int x) {
//         data = x;
//         npx = null;
//     }
// }
class Solution {
    // function should insert the data to the front of the list
    static Node insert(Node head, int data) {
        // Code Here.
         Node new_node=new Node(data);
        if(head==null){
            head=new_node;
            return head;
        }
         new_node.npx=head;
        head=new_node;
        return head;
    }

    // function to print the linked list
    static ArrayList<Integer> getList(Node head) {
        // Code Here.
        ArrayList<Integer>list=new ArrayList<>();
        while(head!=null){
            list.add(head.data);
            head=head.npx;
        }
    
        return list;
    }
}
