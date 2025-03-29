import java.io.*;
import java.util.*;

public class B_Shoe_Shuffling {
    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] s = sc.nextArray(n);
            int[] p = new int[n];
            
            for (int i = 0; i < n; i++) {
                p[i] = i + 1;
            }
            
            int l = 0, r = 0;
            boolean ans = true;
            
            while (r < n) {
                while (r < n - 1 && s[r] == s[r + 1]) {
                    r++;
                }
                
                if (l == r) {
                    ans = false;
                } else {
                    int temp = p[r];
                    for (int i = r; i > l; i--) {
                        p[i] = p[i - 1];
                    }
                    p[l] = temp;
                }
                l = r + 1;
                r++;
            }
            
            if (ans) {
                for (int x : p) {
                    System.out.print(x + " ");
                }
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }

    static class Scan {
        BufferedReader br;
        StringTokenizer st;

        Scan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}
