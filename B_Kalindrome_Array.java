import java.io.*;
import java.util.*;

public class B_Kalindrome_Array {
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
            int n = sc.nextInt();
            int arr[] = sc.nextArray(n);
            int left =0;
            int right= n-1;
            
            while(left < right && arr[left]==arr[right])
            {
                left++;
                right--;
            }
            int ignore = arr[left];
            int l = left; int r= right;
            boolean res = true;
            while(l<r)
            {
                if(arr[l]!=arr[r])
                {
                    if(arr[l]==ignore)
                        l++;
                    else if(arr[r]==ignore)
                        r--;
                    else
                    {
                        res = false;
                        break;
                    }
                }
                else
                {
                    l++;
                    r--;
                }
            }
            if(res)
                out.println("YES");
            else
            {
                ignore = arr[right];
                l = left; r= right;
                res = true;
                while(l<r)
                {
                    if(arr[l]!=arr[r])
                    {
                        if(arr[l]==ignore)
                            l++;
                        else if(arr[r]==ignore)
                            r--;
                        else
                        {
                            res = false;
                            break;
                        }
                    }
                    else
                    {
                        l++;
                        r--;
                    }
                }
                if(res)
                    out.println("YES");
                else
                    out.println("NO");
            }
        }
        out.close();
    }
}
