import java.io.*;
import static java.lang.Math.*;
import java.util.*;

public class B_MEXor_Mixup {
    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        int[][] nextArray2D(int n, int m) {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextInt();
            return arr;
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int pXor;

            if (a % 4 == 1)
                pXor = a - 1;
            else if (a % 4 == 2)
                pXor = 1;
            else if (a % 4 == 3)
                pXor = a;
            else
                pXor = 0;

            if (pXor == b)
                out.println(a);
            else if ((pXor ^ b) != a)
                out.println(a + 1);
            else
                out.println(a + 2);
        }
        out.close();
    }
}
