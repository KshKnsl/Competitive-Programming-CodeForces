import java.util.Arrays;
class Solution 
{
    int longestLength = 0;
    public int lenOfVDiagonal(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < m; j++) 
            {
                if (grid[i][j] == 1) 
                {
                    int a = goStraight(grid, i, j, 1, 1, 1); 
                    int b = goStraight(grid, i, j, 1, 1, -1); 
                    int c = goStraight(grid, i, j, 1, -1, 1);
                    int d = goStraight(grid, i, j, 1, -1, -1);
                    int[] lengths = {a, b, c, d};
                    Arrays.sort(lengths);
                    longestLength = Math.max(longestLength, lengths[2] + lengths[3]);
                }
            }
        }
        return longestLength;
    }

    boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    int getNextValue(int length) {
        return (length % 2 == 0) ? 2 : 0;
    }

    int goStraight(int[][] grid, int x, int y, int length, int dx, int dy) {
        int n = grid.length;
        int m = grid[0].length;
        while (isValid(x + dx, y + dy, n, m) && grid[x + dx][y + dy] == getNextValue(length)) {
            x += dx;
            y += dy;
            length++;
        }
        return length;
    }
}