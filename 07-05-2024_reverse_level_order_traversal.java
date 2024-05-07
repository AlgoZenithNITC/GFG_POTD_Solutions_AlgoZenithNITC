


/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/


class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(node, ans);
        Collections.reverse(ans);
        return ans;
    }

    private void solve(Node root, ArrayList<Integer> ans) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                ans.add(temp.data);
                if (temp.right != null) queue.offer(temp.right);
                if (temp.left != null) queue.offer(temp.left);
            }
        }
    }
}
