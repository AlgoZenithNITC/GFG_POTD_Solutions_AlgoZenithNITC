class Solution
{
    boolean check(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            int leaf=0;
            int nf=0;
            for(int i=0;i<size;i++)
            {
                Node f=q.remove();
                if(f.left==null && f.right==null)
                    leaf++;
                else if(f.left==null || f.right==null) 
                {
                    nf++;
                    q.add(f.left==null?f.right:f.left);
                }
                else
                {
                    nf++;
                    q.add(f.left);
                    q.add(f.right);
                }
            }
            if(leaf>0 && nf>0)
                return false;
        }
        return true;
    }
}
