class Solution{
    public static void printPathsUtil(Node currNode, int sum, int sumSoFar, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans){
        if(currNode == null){
            return;
        }
        sumSoFar += currNode.data;
        path.add(currNode.data);
        if(sumSoFar == sum){
            ans.add(new ArrayList<>(path));
        }
        if(currNode.left != null){
            printPathsUtil(currNode.left, sum, sumSoFar, path, ans);
        }

        if(currNode.right != null){
            printPathsUtil(currNode.right, sum, sumSoFar, path, ans);
        }
        path.remove(path.size() - 1);
    }
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum){
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        printPathsUtil(root, sum, 0, path, ans);
        return ans;
    }
}
