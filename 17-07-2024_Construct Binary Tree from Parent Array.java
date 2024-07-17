class Solution {
    static Node root;

    // Function to construct binary tree from parent array.
    public Node createTree(int arr[]) {
        root = null;
        int n = arr.length;
        // creating an array created[] to keep track of created nodes,
        // initializing all entries as NULL.
        Node[] created = new Node[n];
        for (int i = 0; i < n; i++) created[i] = null;

        for (int i = 0; i < n; i++) createNode(arr, i, created);

        // returning root of created tree.
        return root;
    }

    // Function to create nodes.
    public void createNode(int arr[], int i, Node created[]) {
        // base case if this node is already created.
        if (created[i] != null) return;

        // creating a new node and setting created[i].
        created[i] = new Node(i);

        // if 'i' is root, changing root pointer.
        if (arr[i] == -1) {
            root = created[i];
            return;
        }

        // if parent is not created then we create parent first.
        if (created[arr[i]] == null) createNode(arr, arr[i], created);

        // finding parent pointer.
        Node p = created[arr[i]];

        // if this is first child of parent, we store it as left child.
        if (p.left == null) p.left = created[i];
        // else we store it as right child.
        else
            p.right = created[i];
    }
}