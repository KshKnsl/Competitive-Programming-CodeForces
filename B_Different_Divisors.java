import java.io.*;
import java.util.*;

public class B_Different_Divisors 
{
    public static void main(String[] args) 
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int res=1;
            boolean prime[] = sieve(50_000);
            int d = sc.nextInt();
            int i = d+1;
            while(!prime[i]) i++;
            res = res * i;
            i = res+d;
            while(!prime[i]) i++;
            res = res * i;            
            out.println(res);
        }
        out.close();
    }

    static class Scan 
    {
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

    static boolean[] sieve(int n) { boolean[] isPrime = new boolean[n + 1]; Arrays.fill(isPrime, true); isPrime[0] = isPrime[1] = false; for (int i = 2; i * i <= n; i++) if (isPrime[i]) for (int j = i * i; j <= n; j += i) isPrime[j] = false; return isPrime; }
}
