import java.io.*;
import java.util.*;

public class B_Luntik_and_Subsequences {
    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreTokens())
                try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {}
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int cnt0 = 0, cnt1 = 0;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x == 0) cnt0++;
                if (x == 1) cnt1++;
            }
            long result = ((long) 1 << cnt0) * cnt1;
            out.println(result);
        }
        out.close();
    }
}
