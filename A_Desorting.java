import java.io.*;
import java.util.*;
public class A_Desorting {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;
        Scan() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreTokens()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} } return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        int[] nextArray(int n) { int[] arr = new int[n]; for (int i = 0; i < n; i++) arr[i] = nextInt(); return arr; }
    }
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    public static void main(String[] args) 
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            boolean sorted= true;
            int min=Integer.MAX_VALUE;
            int n = sc.nextInt();
            int[] arr = sc.nextArray(n);
            for(int i=1;i<n;i++)
            {
                if(arr[i]<arr[i-1])
                    sorted=false;
                min=Math.min(min,Math.abs(arr[i]-arr[i-1]));
            }
            // System.out.println(min);
            if(sorted)
            out.println((int)Math.ceil((min+1.0)/2)); 
            else
            out.println(0);
        }
        out.flush();
    }
}