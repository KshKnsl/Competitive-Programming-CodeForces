import java.io.*;
import java.util.*;

public class B_2_D_Traveling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            
            long[] x = new long[n + 1];
            long[] y = new long[n + 1];
            
            for (int i = 1; i <= n; i++) {
                x[i] = sc.nextLong();
                y[i] = sc.nextLong();
            }
            
            long dist = Math.abs(x[s] - x[d]) + Math.abs(y[s] - y[d]);
            long minS = Long.MAX_VALUE / 2, minD = Long.MAX_VALUE / 2;
            
            for (int i = 1; i <= k; i++) {
                minS = Math.min(minS, Math.abs(x[s] - x[i]) + Math.abs(y[s] - y[i]));
                minD = Math.min(minD, Math.abs(x[d] - x[i]) + Math.abs(y[d] - y[i]));
            }
            
            dist = Math.min(dist, minS + minD);
            System.out.println(dist);
        }
        
        sc.close();
    }
}
