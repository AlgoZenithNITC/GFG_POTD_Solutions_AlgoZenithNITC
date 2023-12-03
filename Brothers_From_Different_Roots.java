class Solution{
	public static int countPairs(Node root1, Node root2, int x){
		if(root1 == null || root2 == null){
            return 0;
        }
        Stack<Node> bst1 = new Stack<>();
        Stack<Node> bst2 = new Stack<>();
        Node top1, top2;
        int count = 0;
        while(true){
            while(root1 != null){
                bst1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                bst2.push(root2);
                root2 = root2.right;
            }
            if(bst1.empty() || bst2.empty()){
                break;
            }
            top1 = bst1.peek();
            top2 = bst2.peek();
            if(top1.data + top2.data == x){
                count++;
                bst1.pop();
                bst2.pop();
                root1 = top1.right;
                root2 = top2.left;
            }else if(top1.data + top2.data < x){
                bst1.pop();
                root1 = top1.right;
            }else{
                bst2.pop();
                root2 = top2.left;
            }
        }
        return count;
	}
}
