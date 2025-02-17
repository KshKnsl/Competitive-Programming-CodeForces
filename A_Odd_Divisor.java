import java.io.*;
import java.util.*;

public class A_Odd_Divisor {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;
        Scan() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreTokens()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} } return st.nextToken(); }
        long nextLong() { return Long.parseLong(next()); }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    static boolean isPowerOfTwo(long n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            long n = sc.nextLong();
            if (isPowerOfTwo(n)) {
                out.println("NO");
            } else {
                out.println("YES");
            }
        }
        out.flush();
    }
}
