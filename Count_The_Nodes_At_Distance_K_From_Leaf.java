class Solution
{
    void traverse(Node curr,List<Node> l,int k,Set<Node> ans){
        if(curr==null){return;}
        if(curr.left==null&&curr.right==null){
            if(l.size()>=k){
                if(k!=0)
                ans.add(l.get(l.size()-k));
                else{
                    ans.add(curr);
                }
            }
            return;
        }
        else{
            l.add(curr);
            traverse(curr.left,l,k,ans);
            traverse(curr.right,l,k,ans);
            l.remove(l.size()-1);
        }
    }
    int printKDistantfromLeaf(Node root, int k)
    {
        Set<Node> ans=new HashSet<>();
        List<Node> l=new ArrayList<>();
        traverse(root,new ArrayList<Node>(),k,ans);
        return ans.size();
    }

}
