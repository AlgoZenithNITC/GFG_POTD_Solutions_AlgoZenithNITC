class Solution
{
   
    public static int isSumProperty(Node root) {
      
        if (root == null)
            return 1;

        if (root.left == null && root.right == null)
            return 1;

        int sum = 0;

        if (root.left != null)
            sum += root.left.data;
        if (root.right != null)
            sum += root.right.data;

        return (sum == root.data && isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1) ? 1 : 0;
    }
}
