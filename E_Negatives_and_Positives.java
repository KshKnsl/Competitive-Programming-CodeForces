import java.io.*;
import java.util.*;

public class E_Negatives_and_Positives {
    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() { while (st == null || !st.hasMoreTokens()) try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        long[] nextArray(int n) { long[] arr = new long[n]; for (int i = 0; i < n; i++) arr[i] = nextLong(); return arr; }
        long[][] nextArray2D(int n, int m) { long[][] arr = new long[n][m]; for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) arr[i][j] = nextLong(); return arr; }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            long arr[] = sc.nextArray(n);
            long sum=0;
            int cnt=0;
            long small=Long.MAX_VALUE;
            for(int i=0;i<n;i++) 
            {
                small = Math.min(small, Math.abs(arr[i]));
                sum+=Math.abs(arr[i]);
                if(arr[i]<0) cnt++;
            }
            out.println((cnt%2==0)?sum:( sum-2*small));
        }
        out.close();
    }
}
