import java.util.Scanner;

public class B_1_Palindrome_Game_easy_version {

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int cnt_0 = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    cnt_0++;
                }
            }

            if (cnt_0 == 1) {
                System.out.println("BOB");
                continue;
            }

            if (cnt_0 % 2 == 1) {
                System.out.println("ALICE");
            } else {
                System.out.println("BOB");
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        solve();
    }
}
