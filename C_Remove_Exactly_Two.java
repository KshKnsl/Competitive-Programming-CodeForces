import java.io.*;
import java.util.*;
public class C_Remove_Exactly_Two {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;
        Scan() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreTokens()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} } return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
    }
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) 
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] adjList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjList[i] = new ArrayList<>();
            }
            int degree[] = new int[n];
            for(int i=0;i<n-1;i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();

                degree[a-1]++;
                degree[b-1]++;

                adjList[a-1].add(b-1);
                adjList[b-1].add(a-1);
            }


            // for (int i = 0; i < n; i++) {
            //     out.print(i + ": ");
            //     for (int neighbor : adjList[i]) {
            //         out.print(neighbor + " ");
            //     }
            //     out.println();
            // }
            
            int maxDegree = 0;
            int vertexToRemove = -1;
            for (int i = 0; i < n; i++) {
                if (degree[i] > maxDegree) {
                    maxDegree = degree[i];
                    vertexToRemove = i;
                }
            }

            int res = maxDegree;

            for (int neighbor : adjList[vertexToRemove]) 
            {
                degree[neighbor]--;
                adjList[neighbor].remove((Integer) vertexToRemove);
            }
            degree[vertexToRemove] = 0;
            adjList[vertexToRemove].clear();

            // for (int i = 0; i < n; i++) {
            //     out.print(i + ": ");
            //     for (int neighbor : adjList[i]) {
            //         out.print(neighbor + " ");
            //     }
            //     out.println();
            // }
            
            maxDegree = 0;
            for (int i = 0; i < n; i++) {
                if (degree[i] > maxDegree) {
                    maxDegree = degree[i];
                }
            }
            res += maxDegree - 1;
            out.println(res); 
        }
        out.flush();
    }
}
