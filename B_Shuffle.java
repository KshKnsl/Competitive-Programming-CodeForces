
import java.io.*;
import java.util.*;

public class B_Shuffle {

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int m = sc.nextInt();
            int l = x, r = x;

            for (int i = 0; i < m; i++) {
                int L = sc.nextInt();
                int R = sc.nextInt();
                if (Math.max(l, L) <= Math.min(r, R)) {
                    l = Math.min(l, L);
                    r = Math.max(r, R);
                }
            }

            out.println(r - l + 1);
        }
        out.close();
    }

    static class Scan {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}
