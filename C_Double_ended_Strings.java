import java.io.*;
import static java.lang.Math.*;
import java.util.*;

public class C_Double_ended_Strings {
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
            int res=Integer.MAX_VALUE;
            String a = sc.next();
            String b = sc.next();
            for(int i=0;i<a.length();i++)
            {
                for(int j=i+1;j<=a.length();j++)
                {
                    if(b.contains(a.substring(i,j)))
                    {
                        res=min(res,a.length()-(j-i)+ b.length()-(j-i));
                    }
                }
            }

            if(res==Integer.MAX_VALUE)
            {
                res=a.length()+b.length();
            }
            out.println(res);
        }
        out.close();
    }
}
