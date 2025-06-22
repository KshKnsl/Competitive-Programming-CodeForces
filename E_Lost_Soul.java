import java.io.*;
import java.util.*;

public class E_Lost_Soul {
    static int calcNoRem(int[] a, int[] b, int len, int after) {
        if (len <= 0) {
            return 0;
        }
        int maxMatch = 0;
        for (int i = len - 1; i >= 0; i--) {
            int ind = after + i;
            boolean match = false;
            if (a[ind] == b[ind]) {
                match = true;
            } else if (i + 1 < len) {
                int nexti = after + i + 1;
                if (a[ind] == a[nexti] ||
                        b[ind] == b[nexti] ||
                        a[nexti] == b[nexti]) {
                    match = true;
                }
            }
            if (match) {
                maxMatch = i + 1;
                break;
            }
        }
        return maxMatch;
    }

    static int calc2(int[] a, int[] b, int n) {
        int ans = 0;
        if (n >= 3) {
            Set<Integer> suf = new HashSet<>();
            for (int j = n - 3; j >= 0; j--) {
                suf.add(a[j + 2]);
                suf.add(b[j + 2]);
                if (suf.contains(a[j]) || suf.contains(b[j])) {
                    ans = j + 1;
                    break;
                }
            }
        }
        return ans;
    }

    static int calcRemEnds(int[] a, int[] b, int n) {
        int ans = 0;
        if (n >= 1) {
            ans = Math.max(ans, calcNoRem(a, b, n - 1, 1));
            ans = Math.max(ans, calcNoRem(a, b, n - 1, 0));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = sc.nextArray(n);
            int[] b = sc.nextArray(n);

            if (n == 0) {
                out.println(0);
                continue;
            }

            int ans1 = calcNoRem(a, b, n, 0);
            int ans2 = calc2(a, b, n);
            int ans3 = calcRemEnds(a, b, n);

            out.println(Math.max(ans1, Math.max(ans2, ans3)));
        }
        out.close();
    }

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

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}