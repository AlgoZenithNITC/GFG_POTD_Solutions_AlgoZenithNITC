class Solution {
    public ArrayList<Integer> leafNodes(int[] preorder) {
        int n = preorder.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> leafs = new ArrayList<>();
        int leaf = 0;

        for (int i = 0; i < n; i++) {
            if (!st.isEmpty() && st.peek() > preorder[i]) {
                st.push(preorder[i]);
            } else {
                int count = 0;
                if (!st.isEmpty()) leaf = st.peek();
                while (!st.isEmpty() && st.peek() < preorder[i]) {
                    st.pop();
                    count++;
                }
                st.push(preorder[i]);
                if (count >= 2) leafs.add(leaf);
            }
        }

        leafs.add(st.peek());
        return leafs;
    }
}
