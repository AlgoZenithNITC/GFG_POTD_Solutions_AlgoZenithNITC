class Solution{
    Node concate(Node left_cdll, Node present_cdll) {
        if (left_cdll == null) {
            return present_cdll;
        }
        if (present_cdll == null) {
            return left_cdll;
        }
        Node left_end = left_cdll.left;
        Node right_end = present_cdll.left;
        left_end.right = present_cdll;
        present_cdll.left = left_end;
        left_cdll.left = right_end;
        right_end.right = left_cdll;
        return left_cdll;
    }
    Node bTreeToClist(Node root){
        if(root == null){
            return null;
        }
        Node left_cdll = bTreeToClist(root.left);
        Node right_cdll = bTreeToClist(root.right);
        root.left = root.right = root;
        Node left_half = concate(left_cdll, root);
        Node right_half = concate(left_half, right_cdll);
        return right_half;
    }
}
