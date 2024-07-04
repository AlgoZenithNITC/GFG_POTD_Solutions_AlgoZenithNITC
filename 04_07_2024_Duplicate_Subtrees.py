class Solution:
    def printAllDups(self, root: 'Node') -> 'List[Node*]':
        def solve(node, mp, ans):
            if not node:
                return "N"
            
            s = str(node.data) + "," + solve(node.left, mp, ans) + "," + solve(node.right, mp, ans)
            mp[s] += 1
            if mp[s] == 2:
                ans.append(node)
            return s
        
        mp = defaultdict(int)
        ans = []
        solve(root, mp, ans)
        return ans

