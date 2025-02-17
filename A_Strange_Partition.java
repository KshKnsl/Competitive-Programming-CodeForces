import java.util.*;

public class A_Strange_Partition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long[] arr = new long[(int) n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            long min = 0, sum = 0;
            for (long c : arr) {
                sum += c;
                min += Math.ceil((double) c / x);
            }
            long max = (long) Math.ceil((double) sum / x);
            System.out.println(max + " " + min);
        }
        sc.close();
    }
}
