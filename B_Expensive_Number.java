
import java.util.Scanner;
public class B_Expensive_Number {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t;
        t= sc.nextInt();
        while (t-- > 0) {
            String n = sc.next();
            int res = 0;
            int z = 0;

            for (int i = 0; i < n.length(); i++) 
            {
                if (n.charAt(i) == '0')
                    z++; 
                else
                    res = Math.max(res, z + 1);
            }
            System.out.println(n.length() - res);
        }
    }
}
