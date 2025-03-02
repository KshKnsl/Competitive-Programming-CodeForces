import java.io.*;
import static java.lang.Math.*;
import java.util.*;

public class B_Luke_is_a_Foodie {
    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() { while (st == null || !st.hasMoreTokens()) try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        int[] nextArray(int n) { int[] arr = new int[n]; for (int i = 0; i < n; i++) arr[i] = nextInt(); return arr; }
        int[][] nextArray2D(int n, int m) { int[][] arr = new int[n][m]; for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) arr[i][j] = nextInt(); return arr; }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007;

    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return (a / gcd((int) a, (int) b)) * b; }
    
    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int res=0;
            int n = sc.nextInt();
            int x = sc.nextInt();
            int arr[] = sc.nextArray(n);
            int min= arr[0];
            int max= arr[0];
            for(int i=1;i<n;i++) 
            {
                min= Math.min(min,arr[i]);
                max= Math.max(max,arr[i]);
                // System.out.println(min+"\t"+max);
                if(max-min>2*x)
                {
                    res++;
                    min= arr[i];
                    max= arr[i];
                }
            }
            out.println(res);
        }
        out.close();
    }
}
