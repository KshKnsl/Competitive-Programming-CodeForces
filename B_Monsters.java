import java.io.*;
import static java.lang.Math.*;
import java.util.*;

public class B_Monsters {
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

    static class Pair{
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = sc.nextArray(n);
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> (b.x!=a.x)?Integer.compare(b.x,a.x):Integer.compare(a.y,b.y));
            for(int i=0;i<n;i++)
            {
                pq.add(new Pair(arr[i]%k==0?k:arr[i]%k, i+1));
            }
            while(!pq.isEmpty())
            {
                Pair p = pq.poll();
                out.print(p.y+ " ");

            }
            out.println();
        }
        out.close();
    }
}
