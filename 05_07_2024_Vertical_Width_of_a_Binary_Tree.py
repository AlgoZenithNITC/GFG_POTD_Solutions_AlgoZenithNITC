from collections import deque

def verticalWidth(root):
    # code here
    if root is None:
        return 0

    maxLevel = 0
    minLevel = 0
    q = deque([(root, 0)])

    while q:
        cur, count = q.popleft()

        if cur.left:
            minLevel = min(minLevel, count - 1)
            q.append((cur.left, count - 1))

        if cur.right:
            maxLevel = max(maxLevel, count + 1)
            q.append((cur.right, count + 1))

    return maxLevel + abs(minLevel) + 1
