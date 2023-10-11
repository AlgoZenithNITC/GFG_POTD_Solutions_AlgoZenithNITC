class Solution{
    String structure(HashMap<String, Integer> mp, Node root){
        if(root == null){
            return "";
        }
        String path = structure(mp, root.left) + Integer.toString(root.data) + structure(mp, root.right);
        mp.put(path, mp.getOrDefault(path, 0) + 1);
        return path;
    }
    int dupSub(Node root){
        HashMap<String, Integer> mp = new HashMap<>();
        String result = structure(mp, root);
        for(Map.Entry<String,Integer> entry : mp.entrySet()){
            if(entry.getKey().length() > 2 && entry.getValue() > 1){
                return 1;
            }
        }
        return 0;
    }
}
