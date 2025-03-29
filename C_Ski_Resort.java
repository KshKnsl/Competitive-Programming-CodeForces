import java.io.*;
import java.util.*;

public class C_Ski_Resort {
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = sc.nextArray(n);
            
            long ans = 0;
            int len = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] <= q) {
                    len++;
                } else {
                    if (len >= k) {
                        ans += (long)(len - k + 1) * (len - k + 2) / 2;
                    }
                    len = 0;
                }
            }
            
            if (len >= k) {
                ans += (long)(len - k + 1) * (len - k + 2) / 2;
            }
            
            out.println(ans);
        }
        out.close();
    }

    static class Scan {
        BufferedReader br;
        StringTokenizer st;

        public Scan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }
}
