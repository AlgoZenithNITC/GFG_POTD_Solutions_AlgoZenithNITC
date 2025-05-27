class Solution:
    def leafNodes(self, preorder: list[int]) -> list[int]:
        n = len(preorder)
        st = []
        leafs = []
        leaf = 0

        for i in range(n):
            if st and st[-1] > preorder[i]:
                st.append(preorder[i])
            else:
                count = 0
                if st:
                    leaf = st[-1]
                while st and st[-1] < preorder[i]:
                    st.pop()
                    count += 1
                st.append(preorder[i])
                if count >= 2:
                    leafs.append(leaf)

        leafs.append(st[-1])
        return leafs
