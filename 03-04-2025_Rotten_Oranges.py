def orangesRotting(self, mat):
    m, n = len(mat), len(mat[0])
    q = []  # Using a list instead of deque
    count, count2 = 0, 0

    for i in range(m):
        for j in range(n):
            if mat[i][j] == 2:
                q.append((i, j))  # Enqueue rotten oranges
            elif mat[i][j] == 1:
                count2 += 1  # Count fresh oranges

    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    while q:
        flag = 0
        size = len(q)

        for _ in range(size):
            i, j = q.pop(0)  # Dequeue (less efficient than deque.popleft())

            for di, dj in directions:
                ni, nj = i + di, j + dj

                if 0 <= ni < m and 0 <= nj < n and mat[ni][nj] == 1:
                    mat[ni][nj] = 2  # Mark as rotten
                    q.append((ni, nj))  # Enqueue new rotten orange
                    flag = 1
                    count2 -= 1

        if flag:
            count += 1

    return count if count2 == 0 else -1
