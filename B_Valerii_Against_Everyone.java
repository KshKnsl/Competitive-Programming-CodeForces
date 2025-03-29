import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_Valerii_Against_Everyone {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Integer> freq = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int b = sc.nextInt();
                freq.put(b, freq.getOrDefault(b, 0) + 1);
            }

            boolean flag = false;
            for (int f : freq.values()) {
                if (f > 1) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
        sc.close();
    }
}
