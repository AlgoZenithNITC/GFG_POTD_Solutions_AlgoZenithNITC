

/*class Tree{
int data;
    Tree left;
    Tree right;
    Tree(int d){
        data=d;
        left=null;
        right=null;
    }
}

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/


class GfG 
{
    //Function to make binary tree from linked list.
    public static Tree help(List<Integer> arr , int idx){
        if(idx>= arr.size()){
            return null;
        }
        Tree newNode = new Tree(arr.get(idx));
        newNode.left = help(arr , 2*idx + 1);
        newNode.right = help(arr , 2*idx + 2);
        return newNode;
        
    }
    public static Tree convert(Node head, Tree node) {
        // add code here.}
        List<Integer> arr = new ArrayList<Integer>();
        Node temp = head;
        while(temp != null){
            arr.add(temp.data);
            temp = temp.next;
        }
        node = help(arr , 0);
        return node;
    }
}  
