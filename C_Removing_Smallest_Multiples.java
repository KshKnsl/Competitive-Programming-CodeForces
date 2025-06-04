import java.io.*;
import java.util.*;

public class C_Removing_Smallest_Multiples {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean[] a = new boolean[n + 1];
            String s = sc.next();
            for (int i = 1; i <= n; i++)
                a[i] = s.charAt(i - 1) == '1';
            long ans = 0;
            int[] cost = new int[n + 1];
            for (int i = n; i >= 1; i--) {
                for (int j = i; j <= n; j += i) {
                    if (a[j])
                        break;
                    cost[j] = i;
                }
            }
            for (int i = 1; i <= n; i++)
                if (!a[i])
                    ans += cost[i];
            System.out.println(ans);
        }
    }
}
