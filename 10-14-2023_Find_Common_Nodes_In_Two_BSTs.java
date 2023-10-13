class Solution{
    public static void root1_nodes(HashMap<Integer, Integer> mp, Node root1){
        if(root1 == null){
            return;
        }
        mp.put(root1.data, mp.getOrDefault(root1.data, 0) + 1);
        root1_nodes(mp, root1.left);
        root1_nodes(mp, root1.right);
    }
    public static void root2_nodes(HashMap<Integer, Integer> mp, Node root2, ArrayList<Integer> ans){
        if(root2 == null){
            return;
        }
        root2_nodes(mp, root2.left, ans);
        if(mp.containsKey(root2.data)){
            ans.add(root2.data);
        }
        root2_nodes(mp, root2.right, ans);
    }
	public static ArrayList<Integer> findCommon(Node root1,Node root2){
	    HashMap<Integer, Integer> mp = new HashMap<>();
        root1_nodes(mp, root1);
        ArrayList<Integer> ans = new ArrayList<>();
        root2_nodes(mp, root2, ans);
        return ans;
    }
}
