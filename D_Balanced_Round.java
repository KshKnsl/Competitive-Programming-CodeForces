import java.util.*;

public class D_Balanced_Round {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int cnt = 1;
            int ans = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] - arr[i - 1] > k) {
                    cnt = 1;
                } else {
                    cnt++;
                }
                ans = Math.max(ans, cnt);
            }
            System.out.println(n - ans);
        }
        sc.close();
    }
}
