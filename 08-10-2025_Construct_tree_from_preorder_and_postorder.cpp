class Solution {
    
    int i = 0;
    int j = 0;
    
    public Node dfs(int[] pre, int post[], int data){
        // if my last data equal to my postOrder data then return null
        if(data == post[j]){
            return null;
        }
        
        Node root = new Node(pre[i++]);
        
        root.left = dfs(pre, post, root.data);
        root.right = dfs(pre, post, root.data);
        j++;      // After exploring both the side increase postOrder by 1
        
        return root;
        
    }
    
    public Node constructTree(int[] pre, int[] post) {
        // code here
        return dfs(pre, post, -1);
    }
}