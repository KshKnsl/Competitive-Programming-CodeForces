import java.io.*;
import java.util.*;

public class B_Array_Cloning_Technique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Integer> q = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                q.put(x, q.getOrDefault(x, 0) + 1);
            }
            int am = 0;
            for (int y : q.values()) {
                am = Math.max(am, y);
            }
            int ans = 0;
            while (am < n) {
                int d = Math.min(n - am, am);
                ans += 1 + d;
                am += d;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
