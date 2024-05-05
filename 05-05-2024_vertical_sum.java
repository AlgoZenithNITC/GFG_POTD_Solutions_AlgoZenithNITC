
/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution {
    int offset = 10001; 
    
    void solve(Node root, int l, Map<Integer, Integer> mp) {
        if (root == null) return;

        solve(root.left, l - 1, mp);

        if (!mp.containsKey(offset + l))
            mp.put(offset + l, root.data);
        else
            mp.put(offset + l, mp.get(offset + l) + root.data);

        solve(root.right, l + 1, mp);
    }

    public ArrayList<Integer> verticalSum(Node root) {
        Map<Integer, Integer> mp = new TreeMap<>();
        
        solve(root, 0, mp);
        
        ArrayList<Integer> ans = new ArrayList<>(mp.values());

        return ans;
    }
}
