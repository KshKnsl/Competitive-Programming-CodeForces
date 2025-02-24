import java.util.*;

public class D_Deletive_Editing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline
        
        while (t-- > 0) {
            String s = sc.next();
            String tStr = sc.next();
            StringBuilder ans = new StringBuilder();
            
            // Use ASCII value for indexing instead of subtracting 'A'
            int[] a = new int[256];
            Arrays.fill(a, 0);
            
            for (int i = 0; i < tStr.length(); i++) {
                int x = Character.toUpperCase(tStr.charAt(i));
                if (x < 256) {
                    a[x]++;
                }
            }
            
            for (int i = s.length() - 1; i >= 0; i--) {
                int x = Character.toUpperCase(s.charAt(i));
                if (x < 256 && a[x] > 0) {
                    ans.append(s.charAt(i));
                    a[x]--;
                }
            }
            
            ans.reverse();
            
            if (ans.toString().equals(tStr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }
}
