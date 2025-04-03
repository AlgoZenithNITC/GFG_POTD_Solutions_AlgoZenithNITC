public int orangesRotting(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    
    Queue<int[]> q = new LinkedList<>();
    int count = 0, count2 = 0;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (mat[i][j] == 2) {
                q.add(new int[]{i, j});
            } else if (mat[i][j] == 1) {
                count2++;
            }
        }
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    while (!q.isEmpty()) {
        int flag = 0;
        int size = q.size();

        for (int z = 0; z < size; z++) {
            int[] temp = q.poll();
            int i = temp[0], j = temp[1];

            for (int[] dir : directions) {
                int ni = i + dir[0], nj = j + dir[1];

                if (ni >= 0 && nj >= 0 && ni < m && nj < n && mat[ni][nj] == 1) {
                    mat[ni][nj] = 2;
                    q.add(new int[]{ni, nj});
                    flag = 1;
                    count2--;
                }
            }
        }

        if (flag == 1) {
            count++;
        }
    }

    return count2 == 0 ? count : -1;
}
