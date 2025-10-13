def solve(root):
    if not root:
        return (0, 0)  # (include, exclude)

    left = solve(root.left)
    right = solve(root.right)

    include = root.data + left[1] + right[1]
    exclude = max(left) + max(right)

    return (include, exclude)

def getMaxSum(root):
    include, exclude = solve(root)
    return max(include, exclude)