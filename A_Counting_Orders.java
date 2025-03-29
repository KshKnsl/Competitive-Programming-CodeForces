import java.io.*;
import java.util.*;

public class A_Counting_Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            Arrays.sort(b);
            
            long result = 1;
            final int MOD = 1000000007;
            
            for (int i = 0; i < n; i++) 
            {
                int geqCount = n - upperBound(a, b[n - 1 - i]);
                int validChoices = Math.max(geqCount - i, 0);
                result = (result * validChoices) % MOD;
            }
            
            out.println(result);
        }
        
        out.close();
        sc.close();
    }
    
    static int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
