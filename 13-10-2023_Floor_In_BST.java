class Solution {
    public static int floor(Node root, int x){
        if(root == null){
            return -1;
        }
        int temp = -1;
        int present = Integer.MIN_VALUE;
        if(root.data > x){
            temp = floor(root.left, x);
        } else if(root.data <= x){
            present = root.data;
            temp = floor(root.right, x);
        }
        return Math.max(present, temp);
    }
}
