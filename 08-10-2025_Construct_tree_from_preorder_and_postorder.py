class Solution:
    def constructTree(self, pre, post):
        # code here
        n = len(pre)
        mpp = {val: i for i,val in enumerate(post)}
        pre_ind = 0
        
        def build(l,r):
            nonlocal pre_ind
            if l > r or pre_ind >= n:
                return None
            
            root = Node(pre[pre_ind])
            pre_ind += 1
            
            if l == r or pre_ind >= n :
                return root
            
            left_val = pre[pre_ind]
            
            mid = mpp[left_val]
            
            root.left = build(l,mid)
            root.right = build(mid+1,r-1)
            return root
        return build(0,n-1)

