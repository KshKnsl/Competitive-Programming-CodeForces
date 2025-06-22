import java.io.*;
import java.util.*;

public class C_Cool_Partition {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            int[] lastOcc = new int[n + 1]; 
            for (int i = 1; i <= n; i++) {
                lastOcc[a[i]] = i;
            }

            int ans = 0;
            int st = 1; 
            Set<Integer> prevDistinct = new HashSet<>();

            while (st <= n) {
                ans++;
                Set<Integer> req = new HashSet<>(prevDistinct);
                Set<Integer> curD = new HashSet<>();
                
                int minLO = n + 1; 
                
                int endIdx = -1; 

                for (int i = st; i <= n; i++) {
                    int v = a[i];
                    
                    req.remove(v); 
                    
                    boolean newEl = curD.add(v);
                    if (newEl) {
                        minLO = Math.min(minLO, lastOcc[v]);
                    }

                    boolean cut = req.isEmpty();
                    
                    if (cut) {
                        if (i < n) { 
                            if (minLO <= i) {
                                cut = false;
                            }
                        }
                    }

                    if (cut) {
                        endIdx = i;
                        break; 
                    }
                }
                
                prevDistinct = curD;
                st = endIdx + 1;
            }

            System.out.println(ans);
        }
    }

    // Fast input
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) { e.printStackTrace(); }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
