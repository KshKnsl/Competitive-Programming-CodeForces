import java.io.*;
import java.util.*;

public class C_Make_Them_Equal {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int tcase = 1; tcase <= t; tcase++) {
            int n = sc.nextInt();
            char ch = sc.next().charAt(0);
            String s = sc.next();
            
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ch) {
                    cnt++;
                }
            }
            
            if (cnt == n) {
                System.out.println(0);
            } else {
                boolean flag = true;
                for (int i = n / 2; i < n && flag; i++) {
                    if (s.charAt(i) == ch) {
                        flag = false;
                        System.out.println(1);
                        System.out.println(i + 1);
                    }
                }
                
                if (flag) {
                    System.out.println(2);
                    System.out.println(n + " " + (n - 1));
                }
            }
        }
        
        sc.close();
    }
}
