import java.util.*;

public class Removing_Digits 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            int temp = i;
            while (temp > 0) {
                int digit = temp % 10;
                temp /= 10;
                if (digit > 0) {
                    dp[i] = Math.min(dp[i], dp[i - digit] + 1);
                }
            }
        }

        System.out.println( dp[n]);
    }
}