import java.io.*;
import java.util.*;

public class B_Flip_the_Bits {
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
    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            boolean res=true;
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            int one=0,zero=0;
            for(int i=0;i<n;i++) 
            {
                if(a.charAt(i)=='0') zero++;
                else one++;
            }
            boolean inverted=false;
            for(int i=n-1;i>=0;i--) 
            {
                if((!inverted && a.charAt(i)==b.charAt(i)) || (inverted && a.charAt(i)!=b.charAt(i)))
                {
                    if(!inverted)
                    {
                        if(a.charAt(i)=='0') zero--;
                        else one--;
                    }
                    else
                    {
                        if(a.charAt(i)=='1') zero--;
                        else one--;
                    }
                    continue;
                }                
                else
                {
                    if(one!=zero)
                    {
                        res= false;
                        break;
                    }
                    else
                    {
                        inverted = !inverted;
                        if(!inverted)
                        {
                            if(a.charAt(i)=='0') zero--;
                            else one--;
                        }
                        else
                        {
                            if(a.charAt(i)=='1') zero--;
                            else one--;
                        }
                    }
                }
            }
            out.println(res?"YES":"NO");
        }
        out.close();
    }
}
