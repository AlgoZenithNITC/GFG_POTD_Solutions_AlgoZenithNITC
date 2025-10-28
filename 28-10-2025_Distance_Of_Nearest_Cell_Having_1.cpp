vector<vector<int>> nearest(vector<vector<int>> &grid)
{
    int n = grid.size();
    int m = grid[0].size();

    vector<vector<int>> ans(n, vector<int>(m, INT_MAX));

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (grid[i][j] == 1)
            {
                ans[i][j] = 0;
                continue;
            }
            for (int k = 0; k < n; k++)
            {
                for (int l = 0; l < m; l++)
                {
                    if (grid[k][l] == 1)
                    {
                        ans[i][j] = min(ans[i][j], abs(i - k) + abs(j - l));
                    }
                }
            }
        }
    }

    return ans;
}
