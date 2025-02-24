import java.io.*;
import java.util.*;

public class A_AvtoBus {
    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() { while (st == null || !st.hasMoreTokens()) try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            if (n % 2 == 1 || n < 4) {
                out.println(-1);
            } else {
                long mn = n / 6;
                if (n % 6 != 0) mn++;
                long mx = n / 4;
                out.println(mn + " " + mx);
            }
        }
        out.close();
    }
}
