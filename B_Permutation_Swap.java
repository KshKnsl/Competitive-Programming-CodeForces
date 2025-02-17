import java.io.*;
import java.util.*;

public class B_Permutation_Swap {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;
        Scan() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreTokens()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} } return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int res = 0;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                res = gcd(res, Math.abs(x - i-1));
            }
            out.println(res);
        }
        out.flush();
    }
}
