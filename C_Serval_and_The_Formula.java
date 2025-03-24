import java.io.*;
import java.util.*;

public class C_Serval_and_The_Formula {
    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() { while (st == null || !st.hasMoreTokens()) try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        int[] nextArray(int n) { int[] arr = new int[n]; for (int i = 0; i < n; i++) arr[i] = nextInt(); return arr; }
        int[][] nextArray2D(int n, int m) { int[][] arr = new int[n][m]; for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) arr[i][j] = nextInt(); return arr; }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static boolean[][][] dp;
    static int[][][] bitChoice;
    static long x, y;

    static boolean solve(int i, int carryX, int carryY) 
    {
        if (i == 62) 
            return !(carryX == 1 && carryY == 1);
        if (dp[i][carryX][carryY] != false) 
            return dp[i][carryX][carryY]; 
        
        int bx = (int) ((x >> i) & 1);
        int by = (int) ((y >> i) & 1);

        for (int bit = 0; bit < 2; bit++) 
        {
            int s1 = bx + bit + carryX;
            int s2 = by + bit + carryY;
            int A_bit = s1 & 1;
            int B_bit = s2 & 1;

            if (A_bit == 1 && B_bit == 1) continue;

            int ncarryX = s1 >> 1;
            int ncarryY = s2 >> 1;

            if (solve(i + 1, ncarryX, ncarryY)) 
            {
                dp[i][carryX][carryY] = true;
                bitChoice[i][carryX][carryY] = bit;
                return true;
            }
        }

        dp[i][carryX][carryY] = false;
        return false;
    }

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            x = sc.nextLong();
            y = sc.nextLong();

            if (x == y) {
                out.println(-1);
                continue;
            }

            dp = new boolean[63][2][2];
            bitChoice = new int[63][2][2];

            if (!solve(0, 0, 0))
            {
                out.println(-1);
                continue;
            }

            long k = 0;
            int i = 0, curCarryX = 0, curCarryY = 0;

            while (i < 62) 
            {
                int bit = bitChoice[i][curCarryX][curCarryY];
                if (bit == 1) 
                    k |= (1L << i);
                curCarryX = ((int) ((x >> i) & 1) + bit + curCarryX) >> 1;
                curCarryY = ((int) ((y >> i) & 1) + bit + curCarryY) >> 1;
                i++;
            }
            out.println(k > 1e18 ? -1 : k);
        }
        out.close();
    }
}