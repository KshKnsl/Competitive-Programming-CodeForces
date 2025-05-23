import java.io.*;
import java.util.*;

public class E_Cardboard_for_Pictures {
    public static void main(String[] args) throws IOException {
        Scan sc = new Scan();
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            long c = sc.nextLong();
            
            long[] a = new long[n];
            long ss = 0;
            long s = 0;
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                ss += (a[i] * a[i]);
                s += a[i];
            }
            
            c -= ss;
            c /= (4 * n);
            
            s /= (2 * n);
            
            long w = (long)Math.sqrt(s * s + c) - s;
            
            System.out.println(w);
        }
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
                    System.err.println("Error reading input: " + e.getMessage());
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
    }
}
